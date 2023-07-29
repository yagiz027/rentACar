package com.yagizers.rentACar.business.Concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yagizers.rentACar.business.Abstracts.CarService;
import com.yagizers.rentACar.business.Abstracts.InvoiceService;
import com.yagizers.rentACar.business.Abstracts.PaymentService;
import com.yagizers.rentACar.business.Abstracts.RentalService;
import com.yagizers.rentACar.business.dtos.requests.create.CreateInvoiceRequest;
import com.yagizers.rentACar.business.dtos.requests.create.CreatePaymentRequest;
import com.yagizers.rentACar.business.dtos.requests.create.CreateRentalRequest;
import com.yagizers.rentACar.business.dtos.requests.update.UpdateRentalRequest;
import com.yagizers.rentACar.business.dtos.responses.create.CreateRentalResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetAllRentalResponses;
import com.yagizers.rentACar.business.dtos.responses.get.GetByIdRentalResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetCarResponse;
import com.yagizers.rentACar.business.dtos.responses.update.UpdateRentalResponse;
import com.yagizers.rentACar.business.rules.RentalBusinessRules;
import com.yagizers.rentACar.common.dto.CreateRentalPaymentRequest;
import com.yagizers.rentACar.core.utilities.mappers.ModelMapperService;
import com.yagizers.rentACar.dataAccess.Abstracts.RentalRepository;
import com.yagizers.rentACar.entities.Rental;
import com.yagizers.rentACar.entities.enums.State;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private ModelMapperService modelMapperService;
    private RentalRepository rentalRepository;
    private RentalBusinessRules rentalBusinessRules;
    private PaymentService paymentService;
    private CarService carService;
    private InvoiceService invoiceService;
    @Override
    public CreateRentalResponse add(CreateRentalRequest request) {
        rentalBusinessRules.checkIfCarNotRented(request.getCarId());
        Rental rental=this.modelMapperService.forRequest().map(request,Rental.class);
        rental.setId(0);
        rental.setStartDateTime(LocalDateTime.now());

        CreateRentalPaymentRequest paymentRequest=new CreateRentalPaymentRequest();
        this.modelMapperService.forRequest().map(request.getPaymentRequest(),CreatePaymentRequest.class);
        paymentRequest.setPrice(getTotalPriceFunc(rental));
        paymentService.processRentalPayment(paymentRequest);
        getTotalPrice(rental);
        carService.changeState(request.getCarId(), State.RENTED);

        CreateInvoiceRequest invoiceRequest=new CreateInvoiceRequest();
        createInvoiceRequest(request,invoiceRequest,rental);
        this.invoiceService.addInvoice(invoiceRequest);

        this.rentalRepository.save(rental); //Save rental to db
        CreateRentalResponse response=this.modelMapperService.forResponse().map(rental,CreateRentalResponse.class); //return rental response to the user
        return response;
    }
    private Rental getTotalPrice(Rental rental){
        double totalPrice=rental.getDailyPrice()*rental.getRentedForDays();
        rental.setTotalPrice(totalPrice);
        return rental;
    }

    private double getTotalPriceFunc(Rental rental){
        double totalPrice=rental.getDailyPrice()*rental.getRentedForDays();
        return totalPrice;
    }

    @Override
    public UpdateRentalResponse update(int id,UpdateRentalRequest request) {
        this.rentalBusinessRules.checkIfRentalExists(id);
        Rental rental=this.modelMapperService.forRequest().map(request,Rental.class);
        rental.setId(id);
        getTotalPrice(rental);

        this.rentalRepository.save(rental);
        UpdateRentalResponse response=this.modelMapperService.forResponse().map(rental,UpdateRentalResponse.class);

        return response;
    }

    @Override
    public GetByIdRentalResponse getRentalById(int id) {
        this.rentalBusinessRules.checkIfRentalExists(id);
        Rental rental=this.rentalRepository.findById(id).orElseThrow();

        rentalBusinessRules.checkIfCarUnderRented(rental.getCar().getId());
        rental.setEndDateTime(LocalDateTime.now());
        carService.changeState(rental.getCar().getId(),State.AVAILABLE);

        this.rentalRepository.save(rental);
        GetByIdRentalResponse response=this.modelMapperService.forResponse().map(rental,GetByIdRentalResponse.class);
        return response;
    }

    @Override
    public List<GetAllRentalResponses> getAllRentals() {
        List<GetAllRentalResponses> rentalResponses=this.rentalRepository.findAll().stream().map(rental ->
                this.modelMapperService.forResponse().map(rental,GetAllRentalResponses.class)).toList();
        return rentalResponses;
    }

    private void createInvoiceRequest(CreateRentalRequest request, CreateInvoiceRequest invoiceRequest, Rental rental) {
        GetCarResponse car = carService.getCarById(request.getCarId());

        invoiceRequest.setRentedAt(rental.getStartDateTime());
        invoiceRequest.setModelName(car.getModelName());
        invoiceRequest.setBrandName(car.getModelBrandName());
        invoiceRequest.setDailyPrice(request.getDailyPrice());
        invoiceRequest.setRentedForDays(request.getRentedForDays());
        invoiceRequest.setCardHolder(request.getPaymentRequest().getCardHolder());
        invoiceRequest.setPlate(car.getPlate());
        invoiceRequest.setModelYear(car.getModelYear());
    }

    @Override
    public void deleteRentalById(int id) {
        this.rentalBusinessRules.checkIfRentalExists(id);
        makeCarAvailable(id);
        setEndDate(id);
    }

    private void setEndDate(int id) {
        Rental rental = rentalRepository.findById(id).orElseThrow();
        rental.setEndDateTime(LocalDateTime.now());
        rentalRepository.save(rental);
    }

    private void makeCarAvailable(int id) {
        int carId=rentalRepository.findById(id).get().getCar().getId();
        this.carService.changeState(carId,State.AVAILABLE);

    }
}

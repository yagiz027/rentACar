package com.yagizers.rentACar.business.Concretes;

import com.yagizers.rentACar.business.Abstracts.PaymentService;
import com.yagizers.rentACar.business.Abstracts.PosService;
import com.yagizers.rentACar.business.dtos.requests.create.CreatePaymentRequest;
import com.yagizers.rentACar.business.dtos.requests.update.UpdatePaymentRequest;
import com.yagizers.rentACar.business.dtos.responses.create.CreatePaymentResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetAllPaymentsResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetPaymentResponse;
import com.yagizers.rentACar.business.dtos.responses.update.UpdatePaymentResponse;
import com.yagizers.rentACar.business.rules.PaymentBussinessRules;
import com.yagizers.rentACar.common.dto.CreateRentalPaymentRequest;
import com.yagizers.rentACar.core.utilities.mappers.ModelMapperService;
import com.yagizers.rentACar.dataAccess.Abstracts.PaymentRepository;
import com.yagizers.rentACar.entities.Payment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private PaymentRepository paymentRepository;
    private PaymentBussinessRules paymentBussinessRules;
    private ModelMapperService modelMapperService;
    private PosService posService;

    @Override
    public List<GetAllPaymentsResponse> getAll() {
        List<Payment> payments=this.paymentRepository.findAll();
        List<GetAllPaymentsResponse> responses=payments.stream()
                .map(payment -> this.modelMapperService.forResponse()
                        .map(payment,GetAllPaymentsResponse.class)).toList();
        return responses;
    }

    @Override
    public GetPaymentResponse getPaymentById(int id) {
        this.paymentBussinessRules.checkIsPaymentExists(id);
        Payment payment=this.paymentRepository.findById(id).orElseThrow();
        GetPaymentResponse response=this.modelMapperService.forResponse().map(payment,GetPaymentResponse.class);
        return response;
    }

    @Override
    public CreatePaymentResponse addPayment(CreatePaymentRequest request) {
        this.paymentBussinessRules.checkIsCarNumberIsExists(request.getCardNumber());
        Payment payment=this.modelMapperService.forRequest().map(request,Payment.class);
        payment.setId(0);
        this.paymentRepository.save(payment);
        CreatePaymentResponse paymentResponse=this.modelMapperService.forResponse().map(payment,CreatePaymentResponse.class);
        return paymentResponse;
    }

    @Override
    public UpdatePaymentResponse updatePayment(int id, UpdatePaymentRequest request) {
        this.paymentBussinessRules.checkIsPaymentExists(id);
        Payment updatedPayment=this.modelMapperService.forRequest().map(request,Payment.class);
        updatedPayment.setId(id);
        this.paymentRepository.save(updatedPayment);
        UpdatePaymentResponse response=this.modelMapperService.forResponse().map(updatedPayment,UpdatePaymentResponse.class);
        return response;
    }

    @Override
    public void deletePayment(int id) {
        this.paymentBussinessRules.checkIsPaymentExists(id);
        this.paymentRepository.deleteById(id);
    }

    @Override
    public void processRentalPayment(CreateRentalPaymentRequest request) {
        this.paymentBussinessRules.checkPaymentIsValid(request); //Ödeme geçerli mi kontrolü
        Payment payment=this.paymentRepository.findByCardNumber(request.getCardNumber()); //request üzerinden gelen cardNumber ile payment'a ulaşılır.
        paymentBussinessRules.checkBalanceIsEnoughForPayment(payment.getBalance(), request.getPrice()); //ilgili payment entity'sinde bulunan balance miktarı request'den gelen price ile karşılaşıtırılır.
        posService.pay(); //Balance yeterli ise ödeme işlemi gerçekleştirilir.
        payment.setBalance(payment.getBalance()- request.getPrice());
        this.paymentRepository.save(payment); //Son olarak total price balance dan çıkarılır ve veritabanına kayıt edilir.
    }
}


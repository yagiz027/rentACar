package com.yagizers.rentACar.business.rules;

import com.yagizers.rentACar.ExceptionManagement.exceptions.BussinessException;
import com.yagizers.rentACar.business.Abstracts.CarService;
import com.yagizers.rentACar.common.exceptionConstants.ExceptionMessages;
import com.yagizers.rentACar.dataAccess.Abstracts.CarRepository;
import com.yagizers.rentACar.dataAccess.Abstracts.RentalRepository;
import com.yagizers.rentACar.entities.Car;
import com.yagizers.rentACar.entities.enums.State;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentalBusinessRules {
    private RentalRepository rentalRepository;
    private CarService carService;
    private ModelMapper modelMapper;

    public void checkIfRentalExists(int id){
        if(!rentalRepository.existsById(id)){
            throw new BussinessException(ExceptionMessages.Rental.NOT_EXISTS);
        }
    }
    public void checkIfCarUnderRented(int carId){
        Car car=this.modelMapper.map(carService.getCarById(carId),Car.class);
        if(car.getState().equals(State.RENTED)){
            throw new BussinessException(ExceptionMessages.Rental.ALREADY_RENTED);
        }
    }
    public void checkIfCarNotRented(int carId){
        Car car=this.modelMapper.map(carService.getCarById(carId),Car.class);
        if(car.getState().equals(State.AVAILABLE)){
            throw new BussinessException(ExceptionMessages.Rental.NOT_RENTED);
        }
    }

    public void checkIfCarAvailable(State state){
        if(!state.equals(State.AVAILABLE)){
            throw new BussinessException(ExceptionMessages.Car.NotAvailable);
        }
    }
}

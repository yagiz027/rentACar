package com.yagizers.rentACar.business.rules;

import com.yagizers.rentACar.ExceptionManagement.exceptions.BussinessException;
import com.yagizers.rentACar.constants.ExceptionMessages;
import com.yagizers.rentACar.dataAccess.Abstracts.CarRepository;
import lombok.AllArgsConstructor;
import org.jboss.logging.Messages;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CarBusinessRules {
    private final CarRepository carRepository;
    public void checkIfCarNotExists(int id){
        if(!carRepository.existsById(id)){
            throw new BussinessException(ExceptionMessages.Car.NotExists);
        }
    }
    public void checkIfCarPlateNotExists(String plate){
        if (!carRepository.existsByPlate(plate)){
            throw new BussinessException(ExceptionMessages.Car.NotExists);
        }
    }
    public void checkIfCarNotAvailable(int id){
        if (!carRepository.findStateById(id)){
            throw new BussinessException(ExceptionMessages.Car.NotAvailable);
        }
    }
}

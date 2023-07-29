package com.yagizers.rentACar.business.rules;

import com.yagizers.rentACar.ExceptionManagement.exceptions.BusinessException;
import com.yagizers.rentACar.common.constants.ExceptionMessages;
import com.yagizers.rentACar.dataAccess.Abstracts.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CarBusinessRules {
    private final CarRepository carRepository;
    public void checkIfCarNotExists(int id){
        if(!carRepository.existsById(id)){
            throw new BusinessException(ExceptionMessages.Car.NotExists);
        }
    }
    public void checkIfCarPlateNotExists(String plate){
        if (!carRepository.existsByPlate(plate)){
            throw new BusinessException(ExceptionMessages.Car.NotExists);
        }
    }
    public void checkIfCarNotAvailable(int id){
        if (!carRepository.findStateById(id)){
            throw new BusinessException(ExceptionMessages.Car.NotAvailable);
        }
    }
}

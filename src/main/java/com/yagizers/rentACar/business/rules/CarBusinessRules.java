package com.yagizers.rentACar.business.rules;

import com.yagizers.rentACar.ExceptionManagement.exceptions.BussinessException;
import com.yagizers.rentACar.dataAccess.Abstracts.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CarBusinessRules {
    private CarRepository carRepository;
    public void checkIfCarPlateDoesNotExists(String carPlate){
        if(!carRepository.existsByPlate(carPlate)){
            throw new BussinessException("Car does not found.");
        }
    }
    public void checkIfCarPlateExists(String carPlate){
        if(carRepository.existsByPlate(carPlate)){
            throw new BussinessException("Car already exists");
        }
    }

    public void checkIfCarIdDoesNotExists(int carId){
        if(carRepository.findById(carId).isEmpty()){
            throw new BussinessException("We couldn't find a car with the given carID");
        }
    }
}

package com.yagizers.rentACar.business.rules;

import org.springframework.stereotype.Service;

import com.yagizers.rentACar.ExceptionManagement.exceptions.BusinessException;
import com.yagizers.rentACar.common.constants.ExceptionMessages;
import com.yagizers.rentACar.dataAccess.Abstracts.MaintenanceRepository;
import com.yagizers.rentACar.entities.enums.State;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MaintenanceBusinessRules {
    private MaintenanceRepository maintenanceRepository;

    public void checkIfMaintenanceExists(int id){
        if(!maintenanceRepository.existsById(id)){
            throw new BusinessException(ExceptionMessages.Maintenance.NotExists);
        }
    }

    public void checkIfCarUnderTheMaintenance(int carId){
        if(maintenanceRepository.existsByCarIdAndIsCompletedFalse(carId)){
            throw new BusinessException(ExceptionMessages.Maintenance.CarIsUnderTheMaintenance);
        }
    }

    public void checkIfCarIsNotUnderTheMaintenance(int carId){
        if(!maintenanceRepository.existsByCarIdAndIsCompletedFalse(carId)){
            throw new BusinessException(ExceptionMessages.Maintenance.CarNotFound);
        }
    }

    public void checkIfCarIsNotAvailableForMaintenance(State state){
        if(state.equals(State.RENTED)){
            throw new BusinessException(ExceptionMessages.Maintenance.NotAvailable);
        }
    }
}

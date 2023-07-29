package com.yagizers.rentACar.business.Concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yagizers.rentACar.business.Abstracts.CarService;
import com.yagizers.rentACar.business.Abstracts.MaintenanceService;
import com.yagizers.rentACar.business.dtos.requests.create.CreateMaintenanceRequest;
import com.yagizers.rentACar.business.dtos.requests.update.UpdateMaintenanceRequest;
import com.yagizers.rentACar.business.dtos.responses.create.CreateMaintenanceResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetAllMaintenanceResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetMaintenanceResponse;
import com.yagizers.rentACar.business.dtos.responses.update.UpdateMaintenanceResponse;
import com.yagizers.rentACar.business.rules.MaintenanceBusinessRules;
import com.yagizers.rentACar.core.utilities.mappers.ModelMapperService;
import com.yagizers.rentACar.dataAccess.Abstracts.MaintenanceRepository;
import com.yagizers.rentACar.entities.Maintenance;
import com.yagizers.rentACar.entities.enums.State;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService{
    private final MaintenanceRepository repository;
    private final ModelMapperService modelMapperService;
    private final MaintenanceBusinessRules rules;
    private final CarService carService;

    @Override
    public List<GetAllMaintenanceResponse> getAllMaintenanceResponse() {
        List<Maintenance> maintenanceList=this.repository.findAll();
        List<GetAllMaintenanceResponse> maintenanceResponses=maintenanceList.stream().map(maintenance -> 
            this.modelMapperService.forResponse().map(maintenance, GetAllMaintenanceResponse.class)
        ).toList();
        return maintenanceResponses;
    }
    @Override
    public GetMaintenanceResponse getById(int id) {
        this.rules.checkIfMaintenanceExists(id);
        Maintenance maintenance=this.repository.findById(id).orElseThrow();
        GetMaintenanceResponse response=this.modelMapperService.forResponse().map(maintenance, GetMaintenanceResponse.class);
        return response;
    }
    @Override
    public CreateMaintenanceResponse add(CreateMaintenanceRequest request) {
        this.rules.checkIfCarIsNotAvailableForMaintenance(carService.getCarById(request.getCarId()).getState());
        this.rules.checkIfCarUnderTheMaintenance(request.getCarId());

        Maintenance maintenance=this.modelMapperService.forResponse().map(request,Maintenance.class);
        maintenance.setId(0);
        maintenance.setCompleted(false);
        maintenance.setStartDate(LocalDateTime.now());
        maintenance.setEndDate(null);
        carService.changeState(request.getCarId(), State.MAINTENANCE);
        this.repository.save(maintenance);
        CreateMaintenanceResponse response=this.modelMapperService.forRequest().map(maintenance, CreateMaintenanceResponse.class);
        return response;
    }
    @Override
    public UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request) {
        this.rules.checkIfMaintenanceExists(id);
        Maintenance maintenance=this.modelMapperService.forRequest().map(request, Maintenance.class);
        maintenance.setId(id);   
        this.repository.save(maintenance);
        UpdateMaintenanceResponse response=this.modelMapperService.forResponse().map(maintenance, UpdateMaintenanceResponse.class);
        return response;
    }
    @Override
    public void deleteById(int id) {
        this.rules.checkIfMaintenanceExists(id);
        this.makeCarAvailableIfIsCompletedFalse(id);
        this.repository.deleteById(id);
    }

    private void makeCarAvailableIfIsCompletedFalse(int id){
        int carId=repository.findById(id).get().getCar().getId();
        if(repository.existsByCarIdAndIsCompletedFalse(carId)){
            carService.changeState(carId, State.AVAILABLE);
        }
    }
    @Override
    public GetMaintenanceResponse returnedCarFromMaintenance(int carId) {
       this.rules.checkIfCarIsNotUnderTheMaintenance(carId);
       Maintenance maintenance=this.repository.findMaintenanceByCarIdAndIsCompletedFalse(carId);
       maintenance.setCompleted(true);
       maintenance.setEndDate(LocalDateTime.now());
       repository.save(maintenance);
       carService.changeState(carId,State.AVAILABLE);
       GetMaintenanceResponse response = this.modelMapperService.forResponse().map(maintenance,GetMaintenanceResponse.class);
       return response;
    }
}

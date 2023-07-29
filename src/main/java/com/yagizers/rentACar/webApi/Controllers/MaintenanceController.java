package com.yagizers.rentACar.webApi.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yagizers.rentACar.business.Abstracts.MaintenanceService;
import com.yagizers.rentACar.business.dtos.requests.create.CreateMaintenanceRequest;
import com.yagizers.rentACar.business.dtos.requests.update.UpdateMaintenanceRequest;
import com.yagizers.rentACar.business.dtos.responses.create.CreateMaintenanceResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetAllMaintenanceResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetMaintenanceResponse;
import com.yagizers.rentACar.business.dtos.responses.update.UpdateMaintenanceResponse;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/maintenance")
public class MaintenanceController {
    private MaintenanceService service;

    @GetMapping()
    public List<GetAllMaintenanceResponse> findAllMaintenance(){
        return service.getAllMaintenanceResponse();
    }

    @GetMapping("{id}")
    public GetMaintenanceResponse getById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateMaintenanceResponse add(@RequestBody CreateMaintenanceRequest createMaintenanceRequest){
        return service.add(createMaintenanceRequest);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateMaintenanceResponse update(@PathVariable int id,@RequestBody UpdateMaintenanceRequest request){
        return service.update(id, request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id){
        service.deleteById(id);
    }

    @PutMapping("/return")
    public GetMaintenanceResponse returnCarFromMaintenance(@RequestParam int carId)
    {
        return service.returnedCarFromMaintenance(carId);
    }
}

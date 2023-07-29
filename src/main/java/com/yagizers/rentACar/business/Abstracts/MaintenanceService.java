package com.yagizers.rentACar.business.Abstracts;

import java.util.List;

import com.yagizers.rentACar.business.dtos.requests.create.CreateMaintenanceRequest;
import com.yagizers.rentACar.business.dtos.requests.update.UpdateMaintenanceRequest;
import com.yagizers.rentACar.business.dtos.responses.create.CreateMaintenanceResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetAllMaintenanceResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetMaintenanceResponse;
import com.yagizers.rentACar.business.dtos.responses.update.UpdateMaintenanceResponse;

public interface MaintenanceService {
    List<GetAllMaintenanceResponse> getAllMaintenanceResponse();
    GetMaintenanceResponse getById(int id);
    GetMaintenanceResponse returnedCarFromMaintenance(int carId);
    CreateMaintenanceResponse add(CreateMaintenanceRequest request);
    UpdateMaintenanceResponse update(int id,UpdateMaintenanceRequest request);
    void deleteById(int id);
}

package com.yagizers.rentACar.business.Abstracts;

import com.yagizers.rentACar.business.dtos.requests.create.CreateCarRequest;
import com.yagizers.rentACar.business.dtos.requests.update.UpdateCarRequest;
import com.yagizers.rentACar.business.dtos.responses.create.CreateCarResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetAllCarResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetCarByPlateResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetCarResponse;
import com.yagizers.rentACar.business.dtos.responses.update.UpdateCarResponse;
import com.yagizers.rentACar.entities.enums.State;

import java.util.List;

public interface CarService {
    CreateCarResponse addCar(CreateCarRequest carRequest);
    UpdateCarResponse updateCar(int id,UpdateCarRequest updateCarRequest);
    void deleteCarById(int carID);
    List<GetAllCarResponse> selectAllCars(boolean includeMaintenance);
    GetCarResponse getCarById(int carId);
    GetCarByPlateResponse getCarByPlate(String carPlate);
    void changeState(int carId, State state);
}

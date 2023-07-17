package com.yagizers.rentACar.business.Abstracts;

import com.yagizers.rentACar.business.dtos.requests.create.CreateCarRequest;
import com.yagizers.rentACar.business.dtos.requests.update.UpdateCarRequest;
import com.yagizers.rentACar.business.dtos.responses.create.CreateCarResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetAllCarResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetCarByIdResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetCarByPlateResponse;
import com.yagizers.rentACar.business.dtos.responses.update.UpdateCarResponse;

import java.util.List;

public interface CarService {
    CreateCarResponse addCar(CreateCarRequest carRequest);
    UpdateCarResponse updateCar(int id,UpdateCarRequest updateCarRequest);
    void deleteCarById(int carID);
    List<GetAllCarResponse> selectAllCars();
    GetCarByIdResponse getCarById(int carId);
    GetCarByPlateResponse getCarByPlate(String carPlate);
}

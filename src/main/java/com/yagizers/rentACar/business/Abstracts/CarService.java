package com.yagizers.rentACar.business.Abstracts;

import com.yagizers.rentACar.business.dtos.requests.car.CreateCarRequest;
import com.yagizers.rentACar.business.dtos.requests.car.UpdateCarRequest;
import com.yagizers.rentACar.business.dtos.responses.car.GetAllCarResponse;
import com.yagizers.rentACar.business.dtos.responses.car.GetCarByIdResponse;
import com.yagizers.rentACar.business.dtos.responses.car.GetCarByPlateResponse;

import java.util.List;

public interface CarService {
    void addCar(CreateCarRequest carRequest);
    void updateCar(UpdateCarRequest updateCarRequest);
    void deleteCarById(int carID);
    List<GetAllCarResponse> selectAllCars();
    GetCarByIdResponse getCarById(int carId);
    GetCarByPlateResponse getCarByPlate(String carPlate);
}

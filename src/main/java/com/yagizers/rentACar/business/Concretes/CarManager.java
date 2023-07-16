package com.yagizers.rentACar.business.Concretes;

import com.yagizers.rentACar.business.Abstracts.CarService;
import com.yagizers.rentACar.business.dtos.requests.car.CreateCarRequest;
import com.yagizers.rentACar.business.dtos.requests.car.UpdateCarRequest;
import com.yagizers.rentACar.business.dtos.responses.car.GetAllCarResponse;
import com.yagizers.rentACar.business.dtos.responses.car.GetCarByIdResponse;
import com.yagizers.rentACar.business.dtos.responses.car.GetCarByPlateResponse;
import com.yagizers.rentACar.business.rules.CarBusinessRules;
import com.yagizers.rentACar.core.utilities.mappers.ModelMapperService;
import com.yagizers.rentACar.dataAccess.Abstracts.CarRepository;
import com.yagizers.rentACar.entities.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;
    private CarBusinessRules carBusinessRules;

    @Override
    public void addCar(CreateCarRequest carRequest) {
        //If car plate does exists in database,program throws a business exception.
        this.carBusinessRules.checkIfCarPlateExists(carRequest.getPlate());
        Car car=this.modelMapperService.forRequest().map(carRequest,Car.class);
        this.carRepository.save(car);
    }

    @Override
    public void updateCar(UpdateCarRequest updateCarRequest) {
        Car updatedCar=this.modelMapperService.forRequest().map(updateCarRequest,Car.class);
        this.carRepository.save(updatedCar);
    }

    @Override
    public void deleteCarById(int carID) {
        this.carRepository.deleteById(carID);
    }

    @Override
    public List<GetAllCarResponse> selectAllCars() {
        List<Car> carList=this.carRepository.findAll();
        List<GetAllCarResponse> responses=carList.stream()
                .map(car->this.modelMapperService.forResponse()
                        .map(car, GetAllCarResponse.class)).toList();
        return responses;
    }

    @Override
    public GetCarByIdResponse getCarById(int carId) {
        this.carBusinessRules.checkIfCarIdDoesNotExists(carId);
        Car car=this.carRepository.findById(carId).orElseThrow();
        return this.modelMapperService.forResponse().map(car,GetCarByIdResponse.class);
    }

    @Override
    public GetCarByPlateResponse getCarByPlate(String carPlate) {
        this.carBusinessRules.checkIfCarPlateDoesNotExists(carPlate);
        Car car=this.carRepository.findByPlate(carPlate);
        return this.modelMapperService.forResponse().map(car,GetCarByPlateResponse.class);
    }
}

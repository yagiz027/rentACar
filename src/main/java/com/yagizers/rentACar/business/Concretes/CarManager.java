package com.yagizers.rentACar.business.Concretes;

import com.yagizers.rentACar.business.Abstracts.CarService;
import com.yagizers.rentACar.business.dtos.requests.create.CreateCarRequest;
import com.yagizers.rentACar.business.dtos.requests.update.UpdateCarRequest;
import com.yagizers.rentACar.business.dtos.responses.create.CreateCarResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetAllCarResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetCarByIdResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetCarByPlateResponse;
import com.yagizers.rentACar.business.dtos.responses.update.UpdateCarResponse;
import com.yagizers.rentACar.business.rules.CarBusinessRules;
import com.yagizers.rentACar.core.utilities.mappers.ModelMapperService;
import com.yagizers.rentACar.dataAccess.Abstracts.CarRepository;
import com.yagizers.rentACar.entities.Car;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;
    private CarBusinessRules carBusinessRules;

    @Override
    public CreateCarResponse addCar(CreateCarRequest carRequest) {
        Car car=this.modelMapperService.forRequest().map(carRequest,Car.class);

        this.carRepository.save(car);

        CreateCarResponse response=this.modelMapperService.forResponse().map(car,CreateCarResponse.class);
        return response;
    }

    //CarService sınfından override edilen bu method güncellenmek istenen Car entity'sinin id sini alır.
    //Daha sonra bu id'ye ait olan Car nesnesinin istenilen özellikleri kullanıcı tarafından güncellenir.
    //Son olarak kullanıcının yapmış olduğu update request e karşılık gelen bir update response döner.
    @Override
    public UpdateCarResponse updateCar(int id,UpdateCarRequest updateCarRequest) {
        Car updatedCar=this.modelMapperService.forRequest().map(updateCarRequest,Car.class);
        updatedCar.setId(id);
        this.carRepository.save(updatedCar);

        UpdateCarResponse response=this.modelMapperService.forResponse().map(updatedCar,UpdateCarResponse.class);
        return response;
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
        this.carBusinessRules.checkIfCarExists(carId);
        Car car=this.carRepository.findById(carId).orElseThrow();
        return this.modelMapperService.forResponse().map(car,GetCarByIdResponse.class);
    }

    @Override
    public GetCarByPlateResponse getCarByPlate(String carPlate) {
        this.carBusinessRules.checkIfCarPlateExists(carPlate);
        Car car=this.carRepository.findByPlate(carPlate);
        return this.modelMapperService.forResponse().map(car,GetCarByPlateResponse.class);
    }
}

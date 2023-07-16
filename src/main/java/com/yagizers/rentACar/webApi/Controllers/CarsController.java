package com.yagizers.rentACar.webApi.Controllers;

import com.yagizers.rentACar.business.Abstracts.CarService;
import com.yagizers.rentACar.business.dtos.requests.car.CreateCarRequest;
import com.yagizers.rentACar.business.dtos.requests.car.UpdateCarRequest;
import com.yagizers.rentACar.business.dtos.responses.car.GetAllCarResponse;
import com.yagizers.rentACar.business.dtos.responses.car.GetCarByIdResponse;
import com.yagizers.rentACar.business.dtos.responses.car.GetCarByPlateResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarsController {
    private CarService carService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCar(CreateCarRequest carRequest){
        this.carService.addCar(carRequest);
    }

    @GetMapping()
    public List<GetAllCarResponse> selectAllCars(){
        return this.carService.selectAllCars();
    }
    @PutMapping
    public void updateCar(UpdateCarRequest updateCarRequest){
        this.carService.updateCar(updateCarRequest);
    }
    @GetMapping("/{carId}")
    public GetCarByIdResponse getCarById(@PathVariable int carId){
        return this.carService.getCarById(carId);
    }
    @GetMapping("/{carPlate}")
    public GetCarByPlateResponse getCarByPlate(@PathVariable String carPlate){
        return this.carService.getCarByPlate(carPlate);
    }

    @DeleteMapping("/{carId}")
    public void deleteCarById(@PathVariable int carId){
        this.carService.deleteCarById(carId);
    }
}

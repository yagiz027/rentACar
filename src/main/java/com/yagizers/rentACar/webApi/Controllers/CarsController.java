package com.yagizers.rentACar.webApi.Controllers;

import com.yagizers.rentACar.business.Abstracts.CarService;
import com.yagizers.rentACar.business.dtos.requests.create.CreateCarRequest;
import com.yagizers.rentACar.business.dtos.requests.update.UpdateCarRequest;
import com.yagizers.rentACar.business.dtos.responses.create.CreateCarResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetAllCarResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetCarResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetCarByPlateResponse;
import com.yagizers.rentACar.business.dtos.responses.update.UpdateCarResponse;
import jakarta.validation.Valid;
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
    public CreateCarResponse addCar(@RequestBody @Valid CreateCarRequest carRequest){
        return this.carService.addCar(carRequest);
    }

    @GetMapping()
    public List<GetAllCarResponse> selectAllCars(@RequestParam(defaultValue ="true") boolean includeMaintenance){
        return this.carService.selectAllCars(includeMaintenance);
    }
    @PutMapping("/{id}")
    public UpdateCarResponse updateCar(@PathVariable int id, @RequestBody UpdateCarRequest updateCarRequest){
        return this.carService.updateCar(id,updateCarRequest);
    }
    @RequestMapping(value = "/byId/{id}",method = RequestMethod.GET)
    public GetCarResponse getCarById(@PathVariable int id){
        return this.carService.getCarById(id);
    }
    @RequestMapping(value = "/byPlate/{plate}",method = RequestMethod.GET)
    public GetCarByPlateResponse getCarByPlate(@PathVariable String plate){
        return this.carService.getCarByPlate(plate);
    }

    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable int id){
        this.carService.deleteCarById(id);
    }
}

package com.yagizers.rentACar.webApi.Controllers;

import com.yagizers.rentACar.business.Abstracts.RentalService;
import com.yagizers.rentACar.business.dtos.requests.create.CreateRentalRequest;
import com.yagizers.rentACar.business.dtos.requests.update.UpdateRentalRequest;
import com.yagizers.rentACar.business.dtos.responses.get.GetAllRentalResponses;
import com.yagizers.rentACar.business.dtos.responses.get.GetByIdRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rental")
@AllArgsConstructor
public class RentalController {
    private RentalService rentalService;
    @GetMapping()
    public List<GetAllRentalResponses> getAllRentals(){
        return this.rentalService.getAllRentals();
    }
    @GetMapping("{id}")
    public GetByIdRentalResponse getRentalById(@PathVariable int id){
        return this.rentalService.getRentalById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addRental(@RequestBody CreateRentalRequest createRentalRequest){
        this.rentalService.add(createRentalRequest);
    }

    @PutMapping("{id}")
    public void updateRental(@PathVariable int id, @RequestBody UpdateRentalRequest updateRentalRequest){
        this.rentalService.update(id,updateRentalRequest);
    }

    @DeleteMapping("{id}")
    public void deleteRental(@PathVariable int id){
        this.rentalService.deleteRentalById(id);
    }
}

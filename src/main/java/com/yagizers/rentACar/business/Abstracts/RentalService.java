package com.yagizers.rentACar.business.Abstracts;

import com.yagizers.rentACar.business.dtos.requests.create.CreateRentalRequest;
import com.yagizers.rentACar.business.dtos.requests.update.UpdateRentalRequest;
import com.yagizers.rentACar.business.dtos.responses.create.CreateRentalResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetAllRentalResponses;
import com.yagizers.rentACar.business.dtos.responses.get.GetByIdRentalResponse;
import com.yagizers.rentACar.business.dtos.responses.update.UpdateRentalResponse;

import java.util.List;

public interface RentalService {
    CreateRentalResponse add(CreateRentalRequest createRentalRequest);
    UpdateRentalResponse update(int id,UpdateRentalRequest updateRentalRequest);
    GetByIdRentalResponse getRentalById(int id);
    List<GetAllRentalResponses> getAllRentals();
    void deleteRentalById(int id);
}

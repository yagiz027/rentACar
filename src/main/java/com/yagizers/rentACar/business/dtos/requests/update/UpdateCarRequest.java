package com.yagizers.rentACar.business.dtos.requests.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCarRequest {
    @Size(min=6,max=9)
    private String carPlate;
    private double dailyPrice;
    private int modelYear;
    private String state;
    private int modelId;
}

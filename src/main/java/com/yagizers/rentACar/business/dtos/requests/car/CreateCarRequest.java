package com.yagizers.rentACar.business.dtos.requests.car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCarRequest {
    @NotNull
    @NotBlank
    @Size(min=6,max=9)
    private String plate;
    @NotBlank
    private double dailyPrice;
    @NotBlank
    private int modelYear;
    @NotBlank
    private String state;
    @NotBlank
    private int modelId;
}

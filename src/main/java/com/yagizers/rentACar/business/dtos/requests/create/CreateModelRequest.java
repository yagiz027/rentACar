package com.yagizers.rentACar.business.dtos.requests.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateModelRequest {
    @NotNull
    @NotBlank //Boşluk yok
    @Size(min=3,max=20)
    private String modelName;
    @NotNull
    @NotBlank
    private int brandId;
}

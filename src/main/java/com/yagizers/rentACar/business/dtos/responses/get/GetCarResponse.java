package com.yagizers.rentACar.business.dtos.responses.get;

import com.yagizers.rentACar.entities.enums.State;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetCarResponse {
    private int id;
    private String plate;
    private double dailyPrice;
    private int modelYear;
    private State state;
    private String modelName;
    private String modelBrandName;
}

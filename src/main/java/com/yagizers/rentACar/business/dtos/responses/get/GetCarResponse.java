package com.yagizers.rentACar.business.dtos.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetCarResponse {
    private int id;
    private String plate;
    private double dailyPrice;
    private int modelYear;
    private String state;
    private int modelId;
}

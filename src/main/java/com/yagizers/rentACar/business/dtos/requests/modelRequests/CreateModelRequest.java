package com.yagizers.rentACar.business.dtos.requests.modelRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {
    private String modelName;
    private int brandId;
}

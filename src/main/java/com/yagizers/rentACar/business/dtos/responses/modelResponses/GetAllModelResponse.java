package com.yagizers.rentACar.business.dtos.responses.modelResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelResponse {
    private int modelId;
    private String modelName;
    private int brandId;
}

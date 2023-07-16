package com.yagizers.rentACar.business.Abstracts;

import com.yagizers.rentACar.business.dtos.requests.model.CreateModelRequest;
import com.yagizers.rentACar.business.dtos.requests.model.UpdateModelRequest;
import com.yagizers.rentACar.business.dtos.responses.modelResponses.GetAllModelResponse;
import com.yagizers.rentACar.business.dtos.responses.modelResponses.GetByIdModelResponse;

import java.util.List;

public  interface ModelService {
    List<GetAllModelResponse> selectAllModels();
    GetByIdModelResponse getModelById(int modelId);
    void addModel(CreateModelRequest createModelRequest);
    void deleteModelById(int modelId);
    void updateModel(UpdateModelRequest updateModelRequest);
}

package com.yagizers.rentACar.business.Abstracts;

import com.yagizers.rentACar.business.dtos.requests.create.CreateModelRequest;
import com.yagizers.rentACar.business.dtos.requests.update.UpdateModelRequest;
import com.yagizers.rentACar.business.dtos.responses.get.GetAllModelResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetByIdModelResponse;

import java.util.List;

public  interface ModelService {
    List<GetAllModelResponse> selectAllModels();
    GetByIdModelResponse getModelById(int modelId);
    void addModel(CreateModelRequest createModelRequest);
    void deleteModelById(int modelId);
    void updateModel(UpdateModelRequest updateModelRequest);
}

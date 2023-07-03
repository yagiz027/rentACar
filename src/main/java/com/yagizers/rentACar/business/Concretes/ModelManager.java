package com.yagizers.rentACar.business.Concretes;

import com.yagizers.rentACar.business.Abstracts.ModelService;
import com.yagizers.rentACar.business.dtos.requests.modelRequests.CreateModelRequest;
import com.yagizers.rentACar.business.dtos.requests.modelRequests.UpdateModelRequest;
import com.yagizers.rentACar.business.dtos.responses.modelResponses.GetAllModelResponse;
import com.yagizers.rentACar.business.dtos.responses.modelResponses.GetByIdModelResponse;
import com.yagizers.rentACar.core.utilities.mappers.ModelMapperService;
import com.yagizers.rentACar.dataAccess.Abstracts.ModelRepository;
import com.yagizers.rentACar.entities.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelResponse> selectAllModels() {
        List<Model> models=this.modelRepository.findAll();
        List<GetAllModelResponse> responses=models.stream().map(model->
                this.modelMapperService.forResponse().map(model,GetAllModelResponse.class)).toList();
        return responses;
    }

    @Override
    public GetByIdModelResponse getModelById(int modelId) {
        Model model=this.modelRepository.findById(modelId).orElseThrow();
        GetByIdModelResponse response=
                this.modelMapperService.forResponse().map(model,GetByIdModelResponse.class);
        return response;
    }

    @Override
    public void addModel(CreateModelRequest createModelRequest) {
        Model model=this.modelMapperService.forRequest().map(createModelRequest,Model.class);
        this.modelRepository.save(model);
    }

    @Override
    public void deleteModelById(int modelId) {
        this.modelRepository.deleteById(modelId);
    }

    @Override
    public void updateModel(UpdateModelRequest updateModelRequest) {
        Model updatedModel=this.modelMapperService.forRequest().map(updateModelRequest,Model.class);
        this.modelRepository.save(updatedModel);
    }
}

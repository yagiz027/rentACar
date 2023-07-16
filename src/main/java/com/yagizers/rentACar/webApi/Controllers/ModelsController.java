package com.yagizers.rentACar.webApi.Controllers;

import com.yagizers.rentACar.business.Abstracts.ModelService;
import com.yagizers.rentACar.business.dtos.requests.model.CreateModelRequest;
import com.yagizers.rentACar.business.dtos.requests.model.UpdateModelRequest;
import com.yagizers.rentACar.business.dtos.responses.modelResponses.GetAllModelResponse;
import com.yagizers.rentACar.business.dtos.responses.modelResponses.GetByIdModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {

    private ModelService modelService;

    @GetMapping()
    public List<GetAllModelResponse> selectAllModels(){
        return this.modelService.selectAllModels();
    }

    @GetMapping("/{modelId}")
    public GetByIdModelResponse getModelById(@PathVariable int modelId){
        return this.modelService.getModelById(modelId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addModel(CreateModelRequest createModelRequest){
        this.modelService.addModel(createModelRequest);
    }

    @PutMapping
    public void updateModel(@RequestBody UpdateModelRequest updateModelRequest){
        this.modelService.updateModel(updateModelRequest);
    }

    @DeleteMapping("/{modelId}")
    public void deleteModel(@PathVariable int modelId){
        this.modelService.deleteModelById(modelId);
    }
}

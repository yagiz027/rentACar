package com.yagizers.rentACar.webApi.Controllers;

import com.yagizers.rentACar.business.Abstracts.ModelService;
import com.yagizers.rentACar.business.dtos.requests.create.CreateModelRequest;
import com.yagizers.rentACar.business.dtos.requests.update.UpdateModelRequest;
import com.yagizers.rentACar.business.dtos.responses.get.GetAllModelResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetByIdModelResponse;
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

    @PutMapping("/{modelId}")
    public void updateModel(@PathVariable int modelId,@RequestBody UpdateModelRequest updateModelRequest){
        this.modelService.updateModel(modelId,updateModelRequest);
    }

    @DeleteMapping("/{modelId}")
    public void deleteModel(@PathVariable int modelId){
        this.modelService.deleteModelById(modelId);
    }
}

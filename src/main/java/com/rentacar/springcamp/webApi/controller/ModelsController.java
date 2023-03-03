package com.rentacar.springcamp.webApi.controller;

import com.rentacar.springcamp.business.abstarcats.ModelService;
import com.rentacar.springcamp.business.requests.CreateModelRequest;
import com.rentacar.springcamp.business.response.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;
    @GetMapping()
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }
    @PostMapping
    public  void add( @RequestBody() CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }
}

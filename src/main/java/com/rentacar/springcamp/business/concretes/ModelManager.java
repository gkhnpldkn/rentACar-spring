package com.rentacar.springcamp.business.concretes;

import com.rentacar.springcamp.business.abstarcats.ModelService;
import com.rentacar.springcamp.business.requests.CreateModelRequest;
import com.rentacar.springcamp.business.response.GetAllModelsResponse;
import com.rentacar.springcamp.core.utilities.mapper.ModelMapperService;
import com.rentacar.springcamp.dataAccess.abstracts.ModelRepository;

import com.rentacar.springcamp.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();

        List<GetAllModelsResponse> modelsResponses=models.stream().map(brand->this.modelMapperService
                .forResponse()
                .map(brand,GetAllModelsResponse.class)).collect(Collectors.toList());
        return modelsResponses;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model= this.modelMapperService.forRequset().map(createModelRequest,Model.class);
        this.modelRepository.save(model);
    }
}

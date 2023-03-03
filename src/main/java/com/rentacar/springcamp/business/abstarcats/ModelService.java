package com.rentacar.springcamp.business.abstarcats;

import com.rentacar.springcamp.business.requests.CreateModelRequest;
import com.rentacar.springcamp.business.response.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
void  add(CreateModelRequest createModelRequest);

}

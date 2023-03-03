package com.rentacar.springcamp.business.abstarcats;

import com.rentacar.springcamp.business.requests.CreateBrandRequest;
import com.rentacar.springcamp.business.requests.UpdateBrandRequest;
import com.rentacar.springcamp.business.response.GetAllBrandResponse;
import com.rentacar.springcamp.business.response.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
List<GetAllBrandResponse> getAll();
void  add(CreateBrandRequest createBrandRequest);
void update(UpdateBrandRequest updateBrandRequest);
void  delete(int id);
GetByIdBrandResponse getById(int id);
}

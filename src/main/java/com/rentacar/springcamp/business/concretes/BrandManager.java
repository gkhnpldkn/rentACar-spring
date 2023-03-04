package com.rentacar.springcamp.business.concretes;

import com.rentacar.springcamp.business.abstarcats.BrandService;
import com.rentacar.springcamp.business.requests.CreateBrandRequest;
import com.rentacar.springcamp.business.requests.UpdateBrandRequest;
import com.rentacar.springcamp.business.response.GetAllBrandResponse;
import com.rentacar.springcamp.business.response.GetByIdBrandResponse;
import com.rentacar.springcamp.business.rules.BrandBusinessRules;
import com.rentacar.springcamp.core.utilities.mapper.ModelMapperService;
import com.rentacar.springcamp.dataAccess.abstracts.BrandRepository;
import com.rentacar.springcamp.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();

        List<GetAllBrandResponse> brandsResponse = brands.stream().map(brand -> this.modelMapperService.forResponse()
                .map(brand, GetAllBrandResponse.class)).collect(Collectors.toList());
        return brandsResponse;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequset().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequset().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).get();
        GetByIdBrandResponse response = this.modelMapperService
                .forResponse().map(brand, GetByIdBrandResponse.class);
        return null;
    }
}

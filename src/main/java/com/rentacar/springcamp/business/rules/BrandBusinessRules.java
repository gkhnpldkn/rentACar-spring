package com.rentacar.springcamp.business.rules;

import com.rentacar.springcamp.core.utilities.exceptions.BusinessException;
import com.rentacar.springcamp.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){
        if (this.brandRepository.existsByName(name)){

            throw new BusinessException("brand alredy exist");
        }
    }
}

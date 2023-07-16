package com.yagizers.rentACar.business.rules;

import com.yagizers.rentACar.dataAccess.Abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String brandName){
        if(this.brandRepository.existsByName(brandName)){
            throw new RuntimeException("Brand already exists."); //Java exception types
        }
    }
}

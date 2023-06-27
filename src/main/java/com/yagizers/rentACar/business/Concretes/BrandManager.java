package com.yagizers.rentACar.business.Concretes;

import com.yagizers.rentACar.business.Abstracts.BrandService;
import com.yagizers.rentACar.dataAccess.Abstracts.BrandRepository;
import com.yagizers.rentACar.entities.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandManager implements BrandService {
    private BrandRepository brandRepository; //Loosely Coupled System

    @Autowired
    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> selectAllBrands() {
        return brandRepository.selectAllBrands();
    }
}

package com.yagizers.rentACar.business.Abstracts;

import com.yagizers.rentACar.entities.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> selectAllBrands();
}

package com.yagizers.rentACar.dataAccess.Abstracts;

import com.yagizers.rentACar.entities.Brand;
import java.util.List;

public interface BrandRepository {
    void addBrand(Brand brand);
    void deleteBrand(Brand brand);
    void updateBrand(Brand brand);
    List<Brand> selectAllBrands();
    Brand selectBrandById(int brandId);
}

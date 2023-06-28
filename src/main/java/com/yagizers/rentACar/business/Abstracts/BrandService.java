package com.yagizers.rentACar.business.Abstracts;

import com.yagizers.rentACar.business.dtos.requests.CreateBrandRequest;
import com.yagizers.rentACar.business.dtos.responses.GetAllBrandsResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> selectAllBrands();
    void addBrand(CreateBrandRequest createBrandRequest);
}

package com.yagizers.rentACar.business.Abstracts;

import com.yagizers.rentACar.business.dtos.requests.brandRequests.CreateBrandRequest;
import com.yagizers.rentACar.business.dtos.requests.brandRequests.UpdateBrandRequest;
import com.yagizers.rentACar.business.dtos.responses.brandResponses.GetAllBrandsResponse;
import com.yagizers.rentACar.business.dtos.responses.brandResponses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> selectAllBrands();
    GetByIdBrandResponse getById(int brandId);
    void addBrand(CreateBrandRequest createBrandRequest);
    void updateBrand(UpdateBrandRequest updateBrandRequest);
    void deleteBrandById(int brandId);
}

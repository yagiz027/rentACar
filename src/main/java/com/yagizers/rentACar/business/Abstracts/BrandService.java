package com.yagizers.rentACar.business.Abstracts;

import com.yagizers.rentACar.business.dtos.requests.create.CreateBrandRequest;
import com.yagizers.rentACar.business.dtos.requests.update.UpdateBrandRequest;
import com.yagizers.rentACar.business.dtos.responses.create.CreateBrandResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetAllBrandsResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetByIdBrandResponse;
import com.yagizers.rentACar.business.dtos.responses.update.UpdateBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> selectAllBrands();
    GetByIdBrandResponse getById(int brandId);
    CreateBrandResponse addBrand(CreateBrandRequest createBrandRequest);
    UpdateBrandResponse updateBrand(int id, UpdateBrandRequest updateBrandRequest);
    void deleteBrandById(int brandId);
}

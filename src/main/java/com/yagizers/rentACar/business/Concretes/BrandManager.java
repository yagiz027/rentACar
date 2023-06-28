package com.yagizers.rentACar.business.Concretes;

import com.yagizers.rentACar.business.Abstracts.BrandService;
import com.yagizers.rentACar.business.dtos.requests.CreateBrandRequest;
import com.yagizers.rentACar.business.dtos.responses.GetAllBrandsResponse;
import com.yagizers.rentACar.core.utilities.mappers.ModelMapperService;
import com.yagizers.rentACar.dataAccess.Abstracts.BrandRepository;
import com.yagizers.rentACar.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository; //Loosely Coupled System
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllBrandsResponse> selectAllBrands() {
        List<Brand> brandList=brandRepository.findAll();
//        List<GetAllBrandsResponse> brandsResponses=new ArrayList<GetAllBrandsResponse>();
//        for(Brand brand : brandList){
//            GetAllBrandsResponse responseItem=new GetAllBrandsResponse();
//            responseItem.setBrandId(brand.getBrandId());
//            responseItem.setBrandName(brand.getBrandName());
//
//            brandsResponses.add(responseItem);
//        }

        List<GetAllBrandsResponse> brandResponses=brandList.stream()
                .map(brand->this.modelMapperService
                        .forResponse().map(brand, GetAllBrandsResponse.class)).toList();
        return brandResponses;
    }

    @Override
    public void addBrand(@RequestBody CreateBrandRequest createBrandRequest) {
        Brand brand=this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        brandRepository.save(brand);
    }
}

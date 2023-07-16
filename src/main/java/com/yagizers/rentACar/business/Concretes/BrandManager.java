package com.yagizers.rentACar.business.Concretes;

import com.yagizers.rentACar.business.Abstracts.BrandService;
import com.yagizers.rentACar.business.dtos.requests.brand.CreateBrandRequest;
import com.yagizers.rentACar.business.dtos.requests.brand.UpdateBrandRequest;
import com.yagizers.rentACar.business.dtos.responses.brandResponses.GetAllBrandsResponse;
import com.yagizers.rentACar.business.dtos.responses.brandResponses.GetByIdBrandResponse;
import com.yagizers.rentACar.business.rules.BrandBusinessRules;
import com.yagizers.rentACar.core.utilities.mappers.ModelMapperService;
import com.yagizers.rentACar.dataAccess.Abstracts.BrandRepository;
import com.yagizers.rentACar.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository; //Loosely Coupled System
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;
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
    public GetByIdBrandResponse getById(int brandId) {
        //Repository'den gelen brand nesnesini modelMapperService ile GetByIdBrandResponse nesnesine dönüştürür.
        Brand brand=this.brandRepository.findById(brandId).orElseThrow();
        GetByIdBrandResponse reponse=
                this.modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);
        return reponse;
    }

    @Override
    public void addBrand(@RequestBody CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getBrandName());

        Brand brand=this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);

        brandRepository.save(brand);
    }

    @Override
    public void updateBrand(UpdateBrandRequest updateBrandRequest) {
        //Kullanıcı tarafından girilen updateBrandRequest bilgisini modelMapperService
        //ile Brand'e dönüştürür ve Repository katmanına iletir.
        Brand updatedBrand=this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        brandRepository.save(updatedBrand);
    }

    @Override
    public void deleteBrandById(int brandId) {
        this.brandRepository.deleteById(brandId);
    }
}

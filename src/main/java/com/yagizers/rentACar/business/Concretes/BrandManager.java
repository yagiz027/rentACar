package com.yagizers.rentACar.business.Concretes;

import com.yagizers.rentACar.business.Abstracts.BrandService;
import com.yagizers.rentACar.business.dtos.requests.create.CreateBrandRequest;
import com.yagizers.rentACar.business.dtos.requests.update.UpdateBrandRequest;
import com.yagizers.rentACar.business.dtos.responses.create.CreateBrandResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetAllBrandsResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetByIdBrandResponse;
import com.yagizers.rentACar.business.dtos.responses.update.UpdateBrandResponse;
import com.yagizers.rentACar.business.rules.BrandBusinessRules;
import com.yagizers.rentACar.core.utilities.mappers.ModelMapperService;
import com.yagizers.rentACar.dataAccess.Abstracts.BrandRepository;
import com.yagizers.rentACar.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
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
    @CacheEvict(value="brand_list",allEntries = true)
    public CreateBrandResponse addBrand(@RequestBody CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getBrandName()); //User Request
        Brand brand=this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        brand.setBrandId(0);

        Brand createBrand=brandRepository.save(brand); //User Response
        CreateBrandResponse response=modelMapperService.forResponse().map(createBrand,CreateBrandResponse.class);
        return response;
    }

    @Override
    public UpdateBrandResponse updateBrand(int id, UpdateBrandRequest updateBrandRequest) {
        //Kullanıcı tarafından girilen updateBrandRequest bilgisini modelMapperService
        //ile Brand'e dönüştürür ve Repository katmanına iletir.
        this.brandBusinessRules.checkIfBrandNameExists(updateBrandRequest.getBrandName()); //Eğer update edilmek istenen brand database de var ise bussiness exception fırlatır.
        Brand updatedBrand=this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        updatedBrand.setBrandId(id);
        this.brandRepository.save(updatedBrand);
        UpdateBrandResponse response=this.modelMapperService.forResponse().map(updatedBrand,UpdateBrandResponse.class);

        return response;
    }

    @Override
    public void deleteBrandById(int brandId) {
        this.brandRepository.deleteById(brandId);
    }
}

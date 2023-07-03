package com.yagizers.rentACar.webApi.Controllers;

import com.yagizers.rentACar.business.Abstracts.BrandService;
import com.yagizers.rentACar.business.dtos.requests.CreateBrandRequest;
import com.yagizers.rentACar.business.dtos.responses.GetAllBrandsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //annotation
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @GetMapping()
    public List<GetAllBrandsResponse> selectAllBrands()    {
        return brandService.selectAllBrands();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED) //Code:201 nesne oluşturuldu.
    public void addBrand(CreateBrandRequest createBrandRequest){
        brandService.addBrand(createBrandRequest);
    }
}

package com.yagizers.rentACar.webApi.Controllers;

import com.yagizers.rentACar.business.Abstracts.BrandService;
import com.yagizers.rentACar.business.dtos.requests.CreateBrandRequest;
import com.yagizers.rentACar.business.dtos.responses.GetAllBrandsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //annotation
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @GetMapping("/selectAll")
    public List<GetAllBrandsResponse> selectAllBrands()    {
        return brandService.selectAllBrands();
    }

    @PostMapping("/addBrand")
    public void addBrand(CreateBrandRequest createBrandRequest){
        brandService.addBrand(createBrandRequest);
    }
}

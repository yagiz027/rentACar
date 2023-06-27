package com.yagizers.rentACar.webApi.Controllers;

import com.yagizers.rentACar.business.Abstracts.BrandService;
import com.yagizers.rentACar.entities.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //annotation
@RequestMapping("/api/brands")
public class BrandsController {
    private BrandService brandService;

    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/selectAll")
    public List<Brand> selectAllBrands()    {
        return brandService.selectAllBrands();
    }
}

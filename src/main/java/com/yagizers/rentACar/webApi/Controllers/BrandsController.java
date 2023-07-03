package com.yagizers.rentACar.webApi.Controllers;

import com.yagizers.rentACar.business.Abstracts.BrandService;
import com.yagizers.rentACar.business.dtos.requests.brandRequests.CreateBrandRequest;
import com.yagizers.rentACar.business.dtos.requests.brandRequests.UpdateBrandRequest;
import com.yagizers.rentACar.business.dtos.responses.brandResponses.GetAllBrandsResponse;
import com.yagizers.rentACar.business.dtos.responses.brandResponses.GetByIdBrandResponse;
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
        return this.brandService.selectAllBrands();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED) //Code:201 nesne oluşturuldu.
    public void addBrand(CreateBrandRequest createBrandRequest){
        this.brandService.addBrand(createBrandRequest);
    }


    /*  '{}' içerisinde yazılan property variable'ı temsil eder
        ve api tarafından kullanılan method'un içerisinde @PathVariable
        annotation'ı kullanılarak oluşturlur.
        Böylece api'in bu variable üzerinden verilere ulaşılması sağlanır.*/
    @GetMapping("/{brandId}")
    public GetByIdBrandResponse getById(@PathVariable  int brandId){
        return this.brandService.getById(brandId);
    }

    //Update işlemleri PutMapping kullanılarak yapılır.
    // Ancak PostMapping kullanılarak da yapılabililr.
    @PutMapping
    public void updateBrand(@RequestBody  UpdateBrandRequest updateBrandRequest){
        this.brandService.updateBrand(updateBrandRequest);
    }

    //Delete işlemleri için DeleteMapping annotation'ı kullanılır.
    @DeleteMapping("/{brandId}")
    public void deleteBrandById(@PathVariable int brandId){
        this.brandService.deleteBrandById(brandId);
    }
}

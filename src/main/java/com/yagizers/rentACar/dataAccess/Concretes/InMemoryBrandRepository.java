package com.yagizers.rentACar.dataAccess.Concretes;

import com.yagizers.rentACar.dataAccess.Abstracts.BrandRepository;
import com.yagizers.rentACar.entities.Brand;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryBrandRepository implements BrandRepository {

    List<Brand> brands;

    public InMemoryBrandRepository() {
        brands=new ArrayList<Brand>();
        brands.add(new Brand(1,"BMW"));
        brands.add(new Brand(1,"Mercedes"));
        brands.add(new Brand(1,"Audi"));
        brands.add(new Brand(1,"Renault"));
        brands.add(new Brand(1,"Fiat"));
    }

    @Override
    public void addBrand(Brand brand) {

    }

    @Override
    public void deleteBrand(Brand brand) {

    }

    @Override
    public void updateBrand(Brand brand) {

    }

    @Override
    public List<Brand> selectAllBrands() {
        return brands;
    }

    @Override
    public Brand selectBrandById(int brandId) {
        return null;
    }


}

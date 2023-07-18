package com.yagizers.rentACar.dataAccess.Abstracts;

import com.yagizers.rentACar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
    boolean existsByName(String brandName);
}

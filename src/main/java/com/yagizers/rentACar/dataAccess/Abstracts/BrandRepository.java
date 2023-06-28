package com.yagizers.rentACar.dataAccess.Abstracts;

import com.yagizers.rentACar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {

}

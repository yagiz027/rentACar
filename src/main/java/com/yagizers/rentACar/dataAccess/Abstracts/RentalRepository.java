package com.yagizers.rentACar.dataAccess.Abstracts;

import com.yagizers.rentACar.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,Integer> {

}

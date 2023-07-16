package com.yagizers.rentACar.dataAccess.Abstracts;

import com.yagizers.rentACar.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
    boolean existsByPlate(String carPlate);

    Car findByPlate(String plate);
}

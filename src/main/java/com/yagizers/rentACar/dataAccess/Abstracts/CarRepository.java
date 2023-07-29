package com.yagizers.rentACar.dataAccess.Abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yagizers.rentACar.entities.Car;
import com.yagizers.rentACar.entities.enums.State;

public interface CarRepository extends JpaRepository<Car, Integer> {
    boolean existsByPlate(String carPlate);

    Car findByPlate(String plate);

    boolean findStateById(int id);

    List<Car> findAllByStateIsNot(State state);
}

package com.yagizers.rentACar.dataAccess.Abstracts;

import com.yagizers.rentACar.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}

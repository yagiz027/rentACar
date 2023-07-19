package com.yagizers.rentACar.dataAccess.Abstracts;

import com.yagizers.rentACar.entities.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<Maintenance,Integer> {
}

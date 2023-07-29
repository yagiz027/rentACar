package com.yagizers.rentACar.business.dtos.responses.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateMaintenanceResponse {
    private int id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int carId;
}

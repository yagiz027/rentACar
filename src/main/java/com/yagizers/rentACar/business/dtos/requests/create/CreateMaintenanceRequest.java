package com.yagizers.rentACar.business.dtos.requests.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateMaintenanceRequest {
    private int carId;
    private String information;
}

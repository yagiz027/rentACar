package com.yagizers.rentACar.business.dtos.requests.update;

import java.sql.Date;

import com.yagizers.rentACar.entities.enums.State;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMaintenanceRequest {
    private int id;
    private Date sendDate;
    private Date returnDate;
    private int carId;
    private State state;

}

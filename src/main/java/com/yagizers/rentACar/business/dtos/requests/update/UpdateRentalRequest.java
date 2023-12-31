package com.yagizers.rentACar.business.dtos.requests.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateRentalRequest {
    private int carId;
    private double dailyPrice;
    private int rentedForDays;
    private LocalDateTime startDate;
}

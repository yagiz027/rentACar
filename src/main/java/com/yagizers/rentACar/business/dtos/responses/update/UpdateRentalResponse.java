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
public class UpdateRentalResponse {
    private int id;
    private int carId;
    private double dailyPrice, totalPrice;
    private int rentedForDays;
    private LocalDateTime startDate;
}

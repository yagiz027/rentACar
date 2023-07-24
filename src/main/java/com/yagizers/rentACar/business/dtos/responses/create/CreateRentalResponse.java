package com.yagizers.rentACar.business.dtos.responses.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateRentalResponse {
    private int id,carId;
    private double dailyPrice,totalPrice;
    private int rentedForDays;
    private LocalDateTime startDate;
}

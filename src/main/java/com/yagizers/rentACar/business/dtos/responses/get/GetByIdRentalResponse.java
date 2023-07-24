package com.yagizers.rentACar.business.dtos.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetByIdRentalResponse {
    private int id;
    private double dailyPrice,totalPrice;
    private LocalDateTime startDateTime,endDateTime;
    private String carName;
}

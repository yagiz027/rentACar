package com.yagizers.rentACar.business.dtos.requests.create;

import com.yagizers.rentACar.business.dtos.requests.RestrictedPaymentRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateRentalRequest {
    private int carId;
    private double dailyPrice;
    private int rentedForDays;
    private RestrictedPaymentRequest paymentRequest;
}

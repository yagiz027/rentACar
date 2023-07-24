package com.yagizers.rentACar.business.dtos.requests.create;

import com.yagizers.rentACar.business.dtos.requests.RestrictedPaymentRequest;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

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

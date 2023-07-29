package com.yagizers.rentACar.business.dtos.requests.create;

import com.yagizers.rentACar.business.dtos.requests.RestrictedPaymentRequest;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatePaymentRequest extends RestrictedPaymentRequest {
    @Min(value = 1)
    private double balance;
}

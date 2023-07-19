package com.yagizers.rentACar.business.dtos.requests.create;

import com.yagizers.rentACar.business.dtos.requests.RestrictedPaymentRequest;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest extends RestrictedPaymentRequest {
    @Min(value = 1)
    private double balance;
}

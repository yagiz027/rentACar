package com.yagizers.rentACar.business.dtos.requests.update;

import com.yagizers.rentACar.business.dtos.requests.RestrictedPaymentRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdatePaymentRequest extends RestrictedPaymentRequest {
    @Min(value = 1)
    @NotBlank
    private double balance;
}

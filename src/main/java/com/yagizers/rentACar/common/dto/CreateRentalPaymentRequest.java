package com.yagizers.rentACar.common.dto;

import com.yagizers.rentACar.business.dtos.requests.create.CreatePaymentRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateRentalPaymentRequest extends CreatePaymentRequest {
    private double price;
}

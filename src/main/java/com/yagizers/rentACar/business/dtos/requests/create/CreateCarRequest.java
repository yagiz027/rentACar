package com.yagizers.rentACar.business.dtos.requests.create;

import com.yagizers.rentACar.common.annotations.NotFutureYear;
import com.yagizers.rentACar.common.constants.RegexConstraints;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCarRequest {
    @NotNull
    @Pattern(regexp = RegexConstraints.Regex.plate, message = "pattern isn't correct")
    private String plate;
    @Min(1)
    private double dailyPrice;
    @Min(1998)
    @NotFutureYear //Custom Annotation
    private int modelYear;
    private String state;
    private int modelId;
}

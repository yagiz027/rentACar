package com.yagizers.rentACar.business.dtos.requests.create;

import com.yagizers.rentACar.common.annotations.NotFutureYear;
import com.yagizers.rentACar.constants.RegexConstraints;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
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

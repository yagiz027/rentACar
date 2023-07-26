package com.yagizers.rentACar.business.dtos.requests.create;

import com.yagizers.rentACar.common.annotations.NotFutureYear;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CreateMaintenanceRequest {
    @Length(min = 10,max = 200)
    @NotNull
    private String information;
    private boolean isCompleted;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int carId;

}

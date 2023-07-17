package com.yagizers.rentACar.common.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class NotFutureYearValidator implements ConstraintValidator<NotFutureYear,Integer> {

    //Belirtilen kısıt, girilen value'nun yani yılın bulunulan yıldan büyük olamaması durumunda true döner.
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        int currentYear= LocalDate.now().getYear();
        return value <= currentYear;
    }
}

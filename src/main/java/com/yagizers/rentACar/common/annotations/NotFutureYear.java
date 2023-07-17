package com.yagizers.rentACar.common.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //Bu annotation'ın çalışma zamanı boyunca erişilebilir olduğunu gösterir.
@Target({ElementType.FIELD,ElementType.PARAMETER}) //Bu annotation'ın field level (yani bir alan/property) veya parameter üzerinde kullanılacağını belirtir.
@Constraint(validatedBy = NotFutureYearValidator.class) //Bu annotation ConstraitValidator interface'ini implemente eden sınıfı belirtir.
//Yani bu annotation'ı custom bir kısıt eklemek istediğimiz annotation'ında veya sınıfta kullanırız.
public @interface NotFutureYear { //Başında '@' işareti olan interface'ler bir annotation bu interface'in bir annotation olduğunu belirtir.
    String message() default "Model year value cannot be in the future";
    //Farklı kullanıcı gruplarını özelleştirilmiş işlemler veya özellikler tanımlamak için kullanılır===> groups
    Class<?>[] groups() default {};
    //Veri transfer nesnelerinde belirli bir grubun mesajlarını taşımak için kullanılır===> Payload.
    Class<? extends Payload>[] payload() default {};
}

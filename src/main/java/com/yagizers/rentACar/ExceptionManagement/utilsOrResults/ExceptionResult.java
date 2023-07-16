package com.yagizers.rentACar.ExceptionManagement.utilsOrResults;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionResult<T>{
    private LocalDateTime timeStamp;
    private String type;
    private T message;

    public ExceptionResult(String type, T message) {
        this.timeStamp = LocalDateTime.now();
        this.type = type;
        this.message = message;
    }

    private String convertToUpperCaseWithUnderScorses(String camelCaseString){
        return camelCaseString.replaceAll("(.)(\\p{Upper})","$1_$2").toUpperCase();
    }
}

package com.yagizers.rentACar.business.dtos.requests.update;

public class UpdatePaymentRequest {
    private String cardNumber;
    private String cardHolder;
    private int cardExpirationYear;
    private int cardExpirationMonth;
    private String cardCVV;
    private double balance;
}

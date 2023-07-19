package com.yagizers.rentACar.common.constants;

public class ExceptionMessages {
    public static class Car{
        public static final String NotExists="CAR_NOT_EXISTS";
        public static final String AlreadyExists="CAR_ALREADY_EXISTS";
        public static final String NotAvailable="CAR_NOT_AVAILABLE";
    }

    public static class Model{
        public static final String NotExists="MODEL_NOT_EXISTS";
        public static final String AlreadyExists="MODEL_ALREADY_EXISTS";
    }

    public static class Brand{
        public static final String NotExists="BRAND_NOT_EXISTS";
        public static final String AlreadyExists="BRAND_ALREADY_EXISTS";
    }
    public static class Invoice
    {
        public static final String NotFound = "INVOICE_NOT_FOUND";
    }

    public static class Payment{
        public static final String NotValidPayment="NOT_A_VALID_PAYMENT";
        public static final String NotEnoughMoney="NOT_ENOUGH_MONEY";
        public static final String Failed="PAYMENT_FAILED";
        public static final String CardNumberAlreadyExists="CARD_NUMBER_ALREADY_EXISTS";
        public static final String PaymentNotFound="PAYMENT_NOT_FOUND";
    }
}

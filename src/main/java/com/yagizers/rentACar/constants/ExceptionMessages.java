package com.yagizers.rentACar.constants;

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
}

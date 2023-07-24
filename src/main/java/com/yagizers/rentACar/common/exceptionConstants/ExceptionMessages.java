package com.yagizers.rentACar.common.exceptionConstants;

public class ExceptionMessages {
    public static class Car
    {
        public static final String NotExists = "CARD_NOT_EXISTS";
        public static final String Exists = "CAR_ALREADY_EXISTS";
        public static final String NotAvailable = "CAR_NOT_AVAILABLE";
    }

    public static class Model
    {
        public static final String NotExists = "MODEL_NOT_EXISTS";
        public static final String Exists = "MODEL_ALREADY_EXISTS";
    }

    public static class Brand
    {
        public static final String NotExists = "BRAND_NOT_EXISTS";
        public static final String Exists = "BRAND_ALREADY_EXISTS";
    }
    public static class Invoice
    {
        public static final String NotFound = "INVOICE_NOT_FOUND";
    }

    public static class Rental{
        public static final String NOT_EXISTS="RENTAL_NOT_EXISTS";
        public static final String NOT_RENTED="CAR_IS_NOT_RENTED";
        public static final String ALREADY_RENTED="CAR_IS_ALREADY_RENTED";
    }
}

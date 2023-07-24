package com.yagizers.rentACar.business.rules;

import com.yagizers.rentACar.ExceptionManagement.exceptions.BussinessException;
import com.yagizers.rentACar.common.constants.ExceptionMessages;
import com.yagizers.rentACar.common.dto.CreateRentalPaymentRequest;
import com.yagizers.rentACar.dataAccess.Abstracts.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentBussinessRules {
    private PaymentRepository paymentRepository;

    public void checkPaymentIsValid(CreateRentalPaymentRequest request){
        if (!paymentRepository.existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCVV(
                request.getCardNumber(),request.getCardHolder(),request.getCardExpirationYear(),request.getCardExpirationMonth(),request.getCardCvv())){
            throw new BussinessException(ExceptionMessages.Payment.NotValidPayment);
        }
    }
    public void checkIsCarNumberIsExists(String cardNumber){
        if(paymentRepository.existsByCardNumber(cardNumber)){
            throw new BussinessException(ExceptionMessages.Payment.CardNumberAlreadyExists);
        }
    }

    public void checkBalanceIsEnoughForPayment(double balance, double price){
        if(balance < price){
            throw new BussinessException(ExceptionMessages.Payment.NotEnoughMoney);
        }
    }

    public void checkIsPaymentExists(int id){
        if(!paymentRepository.existsById(id)){
            throw new BussinessException(ExceptionMessages.Payment.PaymentNotFound);
        }
    }
}

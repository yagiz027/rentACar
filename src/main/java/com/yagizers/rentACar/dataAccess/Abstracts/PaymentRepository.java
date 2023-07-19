package com.yagizers.rentACar.dataAccess.Abstracts;

import com.yagizers.rentACar.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    Payment findByCardNumber(String cardNumber);
    boolean existsByCardNumber(String cardNumber);
    boolean existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCVV(String cardNumber,
                                                                                                  String cardHolder,
                                                                                                  int cardExpirationYear,
                                                                                                  int cardExpirationMonth,
                                                                                                  String cardCVV);
}

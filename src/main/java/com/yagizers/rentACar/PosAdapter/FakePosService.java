package com.yagizers.rentACar.PosAdapter;

import com.yagizers.rentACar.business.Abstracts.PosService;
import com.yagizers.rentACar.common.constants.ExceptionMessages;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FakePosService implements PosService {
    @Override
    public void pay() {
        boolean isPaymentSuccessful=new Random().nextBoolean();
        if(!isPaymentSuccessful){
            throw new RuntimeException(ExceptionMessages.Payment.Failed);
        }
    }
}
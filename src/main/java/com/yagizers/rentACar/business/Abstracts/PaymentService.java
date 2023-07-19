package com.yagizers.rentACar.business.Abstracts;

import com.yagizers.rentACar.business.dtos.requests.create.CreatePaymentRequest;
import com.yagizers.rentACar.business.dtos.requests.update.UpdatePaymentRequest;
import com.yagizers.rentACar.business.dtos.responses.create.CreatePaymentResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetAllPaymentsResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetPaymentResponse;
import com.yagizers.rentACar.business.dtos.responses.update.UpdatePaymentResponse;
import com.yagizers.rentACar.common.dto.CreateRentalPaymentRequest;

import java.util.List;

public interface PaymentService {
    List<GetAllPaymentsResponse> getAll();
    GetPaymentResponse getPaymentById(int id);
    CreatePaymentResponse addPayment(CreatePaymentRequest request);
    UpdatePaymentResponse updatePayment(int id,UpdatePaymentRequest request);
    void deletePayment(int id);
    void processRentalPayment(CreateRentalPaymentRequest request);
}

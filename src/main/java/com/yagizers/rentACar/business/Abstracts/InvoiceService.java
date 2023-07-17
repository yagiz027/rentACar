package com.yagizers.rentACar.business.Abstracts;

import com.yagizers.rentACar.business.dtos.requests.create.CreateInvoiceRequest;
import com.yagizers.rentACar.business.dtos.requests.update.UpdateInvoiceRequest;
import com.yagizers.rentACar.business.dtos.responses.get.GetAllInvoicesesResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetByIdInvoiceResponse;

import java.util.List;

public interface InvoiceService {
    GetByIdInvoiceResponse getInvoiceById(int invoiceId);
    List<GetAllInvoicesesResponse> selectAllInvoice();
    void addInvoice(CreateInvoiceRequest createInvoiceRequest);
    void updateInvoice(UpdateInvoiceRequest updateInvoiceRequest);
    void delete(int id);
}


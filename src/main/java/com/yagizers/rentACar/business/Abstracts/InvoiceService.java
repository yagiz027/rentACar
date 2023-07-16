package com.yagizers.rentACar.business.Abstracts;

import com.yagizers.rentACar.business.dtos.requests.Invoice.CreateInvoiceRequest;
import com.yagizers.rentACar.business.dtos.requests.Invoice.UpdateInvoiceRequest;
import com.yagizers.rentACar.business.dtos.responses.InvoiceResponses.GetAllInvoicesesResponse;
import com.yagizers.rentACar.business.dtos.responses.InvoiceResponses.GetByIdInvoiceResponse;

import java.util.List;

public interface InvoiceService {
    GetByIdInvoiceResponse getInvoiceById(int invoiceId);
    List<GetAllInvoicesesResponse> selectAllInvoice();
    void addInvoice(CreateInvoiceRequest createInvoiceRequest);
    void updateInvoice(UpdateInvoiceRequest updateInvoiceRequest);
    void delete(int id);
}


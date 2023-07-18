package com.yagizers.rentACar.business.Abstracts;

import com.yagizers.rentACar.business.dtos.requests.create.CreateInvoiceRequest;
import com.yagizers.rentACar.business.dtos.requests.update.UpdateInvoiceRequest;
import com.yagizers.rentACar.business.dtos.responses.create.CreateInvoiceResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetAllInvoicesesResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetByIdInvoiceResponse;
import com.yagizers.rentACar.business.dtos.responses.update.UpdateInvoiceRespone;

import java.util.List;

public interface InvoiceService {
    GetByIdInvoiceResponse getInvoiceById(int invoiceId);
    List<GetAllInvoicesesResponse> selectAllInvoice();
    CreateInvoiceResponse addInvoice(CreateInvoiceRequest createInvoiceRequest);
    UpdateInvoiceRespone updateInvoice(int id,UpdateInvoiceRequest updateInvoiceRequest);
    void delete(int id);
}


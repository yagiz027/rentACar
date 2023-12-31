package com.yagizers.rentACar.business.Concretes;

import com.yagizers.rentACar.business.Abstracts.InvoiceService;
import com.yagizers.rentACar.business.dtos.requests.create.CreateInvoiceRequest;
import com.yagizers.rentACar.business.dtos.requests.update.UpdateInvoiceRequest;
import com.yagizers.rentACar.business.dtos.responses.create.CreateInvoiceResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetAllInvoicesesResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetByIdInvoiceResponse;
import com.yagizers.rentACar.business.dtos.responses.update.UpdateInvoiceRespone;
import com.yagizers.rentACar.business.rules.InvoiceBusinessRules;
import com.yagizers.rentACar.core.utilities.mappers.ModelMapperService;
import com.yagizers.rentACar.dataAccess.Abstracts.InvoicesesRepository;
import com.yagizers.rentACar.entities.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private InvoicesesRepository invoicesesRepository;
    private ModelMapperService modelMapperService;
    private InvoiceBusinessRules invoiceBusinessRules;
    @Override
    public GetByIdInvoiceResponse getInvoiceById(int invoiceId) {
        this.invoiceBusinessRules.checkIfInvoiceIdIsExsists(invoiceId);
        Invoice invoice=this.invoicesesRepository.findById(invoiceId).orElseThrow();
        GetByIdInvoiceResponse response=this.modelMapperService.forResponse().map(invoice,GetByIdInvoiceResponse.class);
        return response;
    }

    @Override
    public List<GetAllInvoicesesResponse> selectAllInvoice() {
        List<Invoice> invoices=this.invoicesesRepository.findAll();
        List<GetAllInvoicesesResponse> responses=invoices.stream().
                map(invoice -> this.modelMapperService.forResponse()
                        .map(invoice,GetAllInvoicesesResponse.class)).toList();
        return responses;
    }

    @Override
    public CreateInvoiceResponse addInvoice(CreateInvoiceRequest createInvoiceRequest) {
        CreateInvoiceRequest invoiceRequest=new CreateInvoiceRequest();

        Invoice invoice=this.modelMapperService.forRequest().map(invoiceRequest,Invoice.class);
        invoice.setInvoiceId(0);
        this.invoicesesRepository.save(invoice);

        CreateInvoiceResponse response=this.modelMapperService.forResponse().map(invoice,CreateInvoiceResponse.class);

        return response;
    }

    @Override
    public UpdateInvoiceRespone updateInvoice(int id,UpdateInvoiceRequest updateInvoiceRequest) {
        Invoice updatedInvoice=this.modelMapperService.forRequest().map(updateInvoiceRequest,Invoice.class);
        updatedInvoice.setInvoiceId(id);

        this.invoicesesRepository.save(updatedInvoice);

        UpdateInvoiceRespone response=this.modelMapperService.forResponse().map(updatedInvoice,UpdateInvoiceRespone.class);

        return response;
    }

    @Override
    public void delete(int id) {
        this.invoicesesRepository.deleteById(id);
    }
}

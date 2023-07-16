package com.yagizers.rentACar.webApi.Controllers;

import com.yagizers.rentACar.business.Abstracts.InvoiceService;
import com.yagizers.rentACar.business.dtos.requests.Invoice.CreateInvoiceRequest;
import com.yagizers.rentACar.business.dtos.requests.Invoice.UpdateInvoiceRequest;
import com.yagizers.rentACar.business.dtos.responses.InvoiceResponses.GetAllInvoicesesResponse;
import com.yagizers.rentACar.business.dtos.responses.InvoiceResponses.GetByIdInvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/invoices")
@AllArgsConstructor
public class InvoiceController {
    private InvoiceService invoiceService;

    @GetMapping()
    public List<GetAllInvoicesesResponse> selectAllInvoices(){
        return this.invoiceService.selectAllInvoice();
    }

    @GetMapping("/{invoiceId}")
    public GetByIdInvoiceResponse getByIdInvoiceResponse(@PathVariable int invoiceId){
        return this.invoiceService.getInvoiceById(invoiceId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addInvoice(CreateInvoiceRequest createInvoiceRequest){
        this.invoiceService.addInvoice(createInvoiceRequest);
    }

    @PutMapping
    public void updateInvoice(@RequestBody UpdateInvoiceRequest requests){
        this.invoiceService.updateInvoice(requests);
    }

    @DeleteMapping("/{invoiceId}")
    public void deleteInvoice(@PathVariable int invoiceId){
        this.invoiceService.delete(invoiceId);
    }
}

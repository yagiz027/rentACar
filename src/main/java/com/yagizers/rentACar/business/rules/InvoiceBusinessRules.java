package com.yagizers.rentACar.business.rules;

import com.yagizers.rentACar.ExceptionManagement.exceptions.BusinessException;
import com.yagizers.rentACar.dataAccess.Abstracts.InvoicesesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class InvoiceBusinessRules {
    private InvoicesesRepository invoicesesRepository;
    public void checkIfInvoiceIdIsExsists(int id){
        if(!invoicesesRepository.existsById(id)) {
            throw new BusinessException("Invoice not found");
        }
    }
}

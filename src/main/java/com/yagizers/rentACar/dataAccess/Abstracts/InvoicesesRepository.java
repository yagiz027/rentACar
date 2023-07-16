package com.yagizers.rentACar.dataAccess.Abstracts;

import com.yagizers.rentACar.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoicesesRepository extends JpaRepository<Invoice, Integer>{
}
package com.cydeo.entity;

import com.cydeo.enums.InvoiceStatus;
import com.cydeo.enums.InvoiceType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Table(name = "invoices")
public class Invoice extends BaseEntity {

    private String invoiceNo;
    private InvoiceStatus invoiceStatus;
    private InvoiceType invoiceType;
    private LocalDate date;

//    @ManyToOne
//    private ClientVendor clientVendor;
//    @ManyToOne
//    private Company company;
}

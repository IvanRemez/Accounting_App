package com.cydeo.dto;

import com.cydeo.enums.InvoiceStatus;
import com.cydeo.enums.InvoiceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDTO {

    private Long id;

    private String invoiceNo;
    private InvoiceStatus invoiceStatus;
    private InvoiceType invoiceType;
    private LocalDate localDate;
//    private CompanyDto company;
//    private ClientVendorDto clientVendor;
    private BigDecimal price;
    private Integer tax;
    private BigDecimal total;
}

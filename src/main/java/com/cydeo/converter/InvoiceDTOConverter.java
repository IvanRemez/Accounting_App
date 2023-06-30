package com.cydeo.converter;

import com.sc.accounting_smart_cookies.dto.InvoiceDTO;
import com.sc.accounting_smart_cookies.service.InvoiceService;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class InvoiceDTOConverter implements Converter<Long, InvoiceDTO> {

    private final InvoiceService invoiceService;

    public InvoiceDTOConverter(@Lazy InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public InvoiceDTO convert(Long id) {

        return invoiceService.findById(id);
    }

}

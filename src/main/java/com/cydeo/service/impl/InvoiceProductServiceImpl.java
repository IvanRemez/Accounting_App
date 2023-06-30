package com.cydeo.service.impl;

import com.sc.accounting_smart_cookies.converter.InvoiceProductDTOConverter;
import com.sc.accounting_smart_cookies.dto.InvoiceProductDTO;
import com.sc.accounting_smart_cookies.entity.InvoiceProduct;
import com.sc.accounting_smart_cookies.mapper.MapperUtil;
import com.sc.accounting_smart_cookies.repository.InvoiceProductRepository;
import com.sc.accounting_smart_cookies.service.InvoiceProductService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceProductServiceImpl implements InvoiceProductService {

    private final InvoiceProductRepository invoiceProductRepository;
    private final MapperUtil mapperUtil;
    private final InvoiceProductDTOConverter invoiceProductDTOConverter;

    public InvoiceProductServiceImpl(InvoiceProductRepository invoiceProductRepository, MapperUtil mapperUtil,
                                     @Lazy InvoiceProductDTOConverter invoiceProductDTOConverter) {
        this.invoiceProductRepository = invoiceProductRepository;
        this.mapperUtil = mapperUtil;
        this.invoiceProductDTOConverter = invoiceProductDTOConverter;
    }

    @Override
    public List<InvoiceProductDTO> findAll() {

        List<InvoiceProduct> invoices = invoiceProductRepository.findAll();

        return invoices.stream().map(invoiceProduct ->
                        mapperUtil.convert(invoiceProduct, new InvoiceProductDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public InvoiceProductDTO findById(Long id) {

//        Optional<InvoiceProduct> invoiceProduct = invoiceProductRepository.findById(id);

        return invoiceProductDTOConverter.convert(id);
    }
}
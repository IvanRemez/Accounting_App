package com.cydeo.service;


import com.sc.accounting_smart_cookies.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO findById(Long id);

    void deleteById(Long id);

    List<ProductDTO> findAll();

    ProductDTO save(ProductDTO productDTO);

    ProductDTO update(ProductDTO productDTO);
}
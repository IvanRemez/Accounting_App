package com.cydeo.controller;

import com.sc.accounting_smart_cookies.dto.ProductDTO;
import com.sc.accounting_smart_cookies.enums.ProductUnit;
import com.sc.accounting_smart_cookies.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String listProduct(Model model){
        model.addAttribute("products", productService.findAll());
        return "product/product-list";
    }
    @GetMapping("/create")
    public String createProduct(Model model){
        model.addAttribute("newProduct", new ProductDTO());
        return "product/product-create";
    }
    @PostMapping("/create")
    public String saveProduct(@ModelAttribute("product") ProductDTO productDTO){
        productService.save(productDTO);
        return "redirect:/products/list";
    }
    @GetMapping("/update/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model){
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("products", productService.findAll());
        model.addAttribute("productUnits", ProductUnit.values());

//        model.addAttribute("categories", categoryService.listAll());

        return "product/product-update";
    }
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") ProductDTO productDTO){
        productService.update(productDTO);
        return "redirect:/products/list";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        productService.deleteById(id);
        return "redirect:/products/list";
    }
}
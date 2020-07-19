package com.julkamtonosi.storeSS.controllers;

import com.julkamtonosi.storeSS.models.Product;
import com.julkamtonosi.storeSS.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getProducts();
    }

    @GetMapping("/addProducts")
    public void addProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Bluza 40", "Bluza", "picture1"));
        products.add(new Product(2,"Koszulka 40", "t-shirt", "picture2"));
        products.add(new Product(3,"Kurtka 40", "kurtka", "picture3"));

        productService.addProducts(products);
    }
}

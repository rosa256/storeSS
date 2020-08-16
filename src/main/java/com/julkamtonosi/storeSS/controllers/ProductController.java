package com.julkamtonosi.storeSS.controllers;

import com.julkamtonosi.storeSS.models.Product;
import com.julkamtonosi.storeSS.models.ProductCategory;
import com.julkamtonosi.storeSS.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
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

    @GetMapping("/products/recommended")
    public List<Product> getRecommendedProducts(){
        return productService.getRecommendedProducts();
    }


    @GetMapping("/addProducts")
    public void addProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Bluza 40",ProductCategory.BLUZA, "picture1",new BigDecimal(10), false));
        products.add(new Product(2,"Koszulka 40",ProductCategory.TSHIRT, "picture2",new BigDecimal(10), false));
        products.add(new Product(3,"Kurtka 40",ProductCategory.KURTKA, "picture3",new BigDecimal(10), false));

        products.add(new Product(4,"Bluza 40",ProductCategory.BLUZA, "picture4",new BigDecimal(10), false));
        products.add(new Product(5,"Koszulka 40",ProductCategory.TSHIRT, "picture5",new BigDecimal(10), false));
        products.add(new Product(6,"Kurtka 40",ProductCategory.KURTKA, "picture6",new BigDecimal(10), false));

        //Recommended
        products.add(new Product(7,"Bluza 40(R)",ProductCategory.BLUZA, "picture7",new BigDecimal(10), true));
        products.add(new Product(8,"Koszulka 40(R)",ProductCategory.TSHIRT, "picture8",new BigDecimal(10), true));
        products.add(new Product(9,"Kurtka 40(R)",ProductCategory.BLUZA, "picture9",new BigDecimal(10), true));

        productService.addProducts(products);
    }

    @GetMapping("/categories")
    public List<ProductCategory> getCategories(){
        List<ProductCategory> categoriesList;
        categoriesList = productService.getCategories();

        return categoriesList;
    }

}

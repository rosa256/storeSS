package com.julkamtonosi.storeSS.controllers;

import com.julkamtonosi.storeSS.models.Product;
import com.julkamtonosi.storeSS.models.ProductCategory;
import com.julkamtonosi.storeSS.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
        products.add(new Product(2,"Bluza 40",ProductCategory.BLUZA, "picture4",new BigDecimal(10), false));
        products.add(new Product(3,"Bluza 40(R)",ProductCategory.BLUZA, "picture7",new BigDecimal(10), true));

        products.add(new Product(4,"T-Shirt EKIPA Flowers Biały","t-shirt-ekipa-flowers-bialy", ProductCategory.TSHIRT, "picture2",new BigDecimal(10), false));
        products.add(new Product(5,"T-Shirt EKIPA Flowers Czarny","t-shirt-ekipa-flowers-czarny", ProductCategory.TSHIRT, "picture5",new BigDecimal(10), false));
        products.add(new Product(6,"T-Shirt EKIPA Signs Czarny","t-shirt-ekipa-signs-czarny",ProductCategory.TSHIRT, "picture8",new BigDecimal(10), true));

        //Recommended
        products.add(new Product(7,"Kurtka 40",ProductCategory.GADZET, "picture6",new BigDecimal(10), false));
        products.add(new Product(8,"Kurtka 40",ProductCategory.GADZET, "picture3",new BigDecimal(10), false));
        products.add(new Product(9,"Kurtka 40(R)",ProductCategory.GADZET, "picture9",new BigDecimal(10), true));

        productService.addProducts(products);
    }

    @GetMapping("/categories")
    public List<ProductCategory> getCategories(){
        List<ProductCategory> categoriesList;
        categoriesList = productService.getCategories();

        return categoriesList;
    }

}

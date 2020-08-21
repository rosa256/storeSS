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
        products.add(new Product(1,"Bluza EKIPATONOSI KOLOR 40","bluza-ekipatonosi-kolor-40",ProductCategory.BLUZA, "picture1",new BigDecimal(10), false));
        products.add(new Product(2,"Bluza Kameleon Czarna","bluza-kameleon-czarna",ProductCategory.BLUZA, "picture4",new BigDecimal(10), false));

        products.add(new Product(4,"T-Shirt EKIPA Flowers Biały","tshirt-ekipa-flowers-bialy", ProductCategory.TSHIRT, "picture2",new BigDecimal(10), false));
        products.add(new Product(5,"T-Shirt EKIPA Flowers Czarny","tshirt-ekipa-flowers-czarny", ProductCategory.TSHIRT, "picture5",new BigDecimal(10), false));
        products.add(new Product(6,"T-Shirt EKIPA Signs Czarny","tshirt-ekipa-signs-czarny",ProductCategory.TSHIRT, "picture8",new BigDecimal(10), true));

        //Recommended
        products.add(new Product(7,"Brelok Mini Majk","brelok-mini-majk", ProductCategory.GADZET, "picture6",new BigDecimal(10), false));
        products.add(new Product(8,"Kubek Friz","kubek-friz", ProductCategory.GADZET, "picture3",new BigDecimal(10), false));

        productService.addProducts(products);
    }

    @GetMapping("/categories")
    public List<ProductCategory> getCategories(){
        List<ProductCategory> categoriesList;
        categoriesList = productService.getCategories();

        return categoriesList;
    }

}

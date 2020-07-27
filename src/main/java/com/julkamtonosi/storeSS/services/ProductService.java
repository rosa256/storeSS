package com.julkamtonosi.storeSS.services;

import com.julkamtonosi.storeSS.models.Product;
import com.julkamtonosi.storeSS.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public List<Product> getRecommendedProducts(){
        //TODO: Find Recommended products
        List<Product> productList = productRepository.findAll();
        List<Product> recommendedProducts = new ArrayList<>();
        recommendedProducts.add(productList.get(productList.size()-1));
        recommendedProducts.add(productList.get(productList.size()-2));
        recommendedProducts.add(productList.get(productList.size()-3));
        return recommendedProducts;
    }

    public void addProducts(List<Product> products){
        for (Product p: products)
            productRepository.save(p);
    }
}

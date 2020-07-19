package com.julkamtonosi.storeSS.services;

import com.julkamtonosi.storeSS.models.Product;
import com.julkamtonosi.storeSS.repositories.ProductRepository;
import org.springframework.stereotype.Service;

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
    public void addProducts(List<Product> products){
        for (Product p: products)
            productRepository.save(p);
    }
}

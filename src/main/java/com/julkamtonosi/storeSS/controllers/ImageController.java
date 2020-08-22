package com.julkamtonosi.storeSS.controllers;

import com.julkamtonosi.storeSS.models.Product;
import com.julkamtonosi.storeSS.models.ProductCategory;
import com.julkamtonosi.storeSS.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
public class ImageController {

    private ProductService productService;

    @Autowired
    public ImageController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/img/kategoria/{category}/{nameUrl}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getImageLink(@PathVariable String category, @PathVariable String nameUrl) throws IOException {
        category = category.toLowerCase();
        ClassPathResource imgFile;
        if(nameUrl.contains("hovered")){
            nameUrl = nameUrl.replace("-hovered","");
            imgFile = new ClassPathResource("static/products/"+ category +"/"+ nameUrl + "/"+ nameUrl + "-hovered.jpg");
        }else{
            imgFile = new ClassPathResource("static/products/"+ category +"/"+ nameUrl + "/"+ nameUrl + ".jpg");
        }

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(imgFile.getInputStream()));
    }

    @RequestMapping(value = "/kategoria/{category}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<List<Product>> getProductsImageLinkByCategory(@PathVariable String category) throws IOException {
        List<Product> productsByCategory = productService.getProductsByCategory(category);
        setFullImageLinkForProducts(productsByCategory, category);

        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(productsByCategory);
    }

    private void setFullImageLinkForProducts(List<Product> products, String category) {
        for(Product product : products) {
            String fullImageLink = "http://localhost:8080/img/kategoria/" + category + "/" + product.getNameUrl();
            product.setImageUrl(fullImageLink);
            product.setHoveredImageUrl(fullImageLink + "-hovered");
        }
    }
}

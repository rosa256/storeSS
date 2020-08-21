package com.julkamtonosi.storeSS.controllers;

import com.julkamtonosi.storeSS.models.ProductCategory;
import com.julkamtonosi.storeSS.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
public class ImageController {

    private ProductService productService;

    @Autowired
    public ImageController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/kategoria/{category}/{nameUrl}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getImageLink(@PathVariable String category, @PathVariable String nameUrl) throws IOException {
        category = category.toLowerCase();
        ClassPathResource imgFile = new ClassPathResource("static/products/"+ category +"/"+ nameUrl);

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(imgFile.getInputStream()));
    }

    @RequestMapping(value = "/kategoria/{category}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<List<String>> getProductsImageLinkByCategory(@PathVariable String category) throws IOException {
        List<String> productsNameURLs = productService.getProductsNameURLsByCategory(category);
        List<String> productImageLinks = createImageLinks(productsNameURLs, category);
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(productImageLinks);
    }

    private List<String> createImageLinks(List<String> productsNameURLs, String category) {
        List<String> imageLinks = new ArrayList<>();
        for(String productNameURL : productsNameURLs) {
            String imageLink = "/kategoria/" + category + "/" + productNameURL;
            imageLinks.add(imageLink);
        }

        return imageLinks;
    }
}

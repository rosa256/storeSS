package com.julkamtonosi.storeSS.repositories;

import com.julkamtonosi.storeSS.models.Product;
import com.julkamtonosi.storeSS.models.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select distinct p.category from Product p")
    List<ProductCategory> findDistinctProd();

    List<Product> findAllByCategory(ProductCategory category);

}

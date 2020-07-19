package com.julkamtonosi.storeSS.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class Product {
    public Product() {
    }
    @Id
    private Integer id;
    private String name;
    private String category;
    private String picture;
}

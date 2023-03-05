package com.serveTechIT.ServeTechIt.storeProduct;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String price;
    private String name;
    @Enumerated
    private Categories category;
//    private List tags;
//    private   relatedProducts;

    public Product(String price, String name, Categories category) {
        this.price = price;
        this.name = name;
        this.category = category;

    }
}

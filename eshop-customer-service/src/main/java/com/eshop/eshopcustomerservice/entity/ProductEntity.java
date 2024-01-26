package com.eshop.eshopcustomerservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCTS")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "PRODUCT")
    private Long product;

    @Column(name = "MANUFACTURER")
    private Long manufacturer;

    @Column(name = "MERCHANT")
    private Long merchant;
}

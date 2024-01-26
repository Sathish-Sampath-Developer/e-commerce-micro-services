package com.eshop.eshopcoreservice.entity;

import com.eshop.eshopcoreservice.constants.SchemaConstant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "PRODUCTS")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "SKU")
    private String sku;

    @Column(name = "THUMBNAIL")
    private String thumbnail;

    @Column(name = "IMAGES")
    private List<String> product_images;

    @NotNull
    @Column(name = "QUANTITY")
    private Integer productQuantity = 0;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_AVAILABLE")
    private Date productDateAvailable;

    @Column(name = "REGION")
    private String region = SchemaConstant.ALL_REGIONS;

    @Column(name = "AVAILABLE")
    private Boolean available;

    @Column(name = "PRODUCT_QUANTITY_ORDER_MIN")
    private Integer productQuantityOrderMin = 0;

    @Column(name = "PRODUCT_QUANTITY_ORDER_MAX")
    private Integer productQuantityOrderMax = 0;

    @Column(name = "CATEGORIES")
    private List<String> categories;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "MANUFACTURER_ID", nullable = false)
    private ManufacturerEntity manufacturer;

    @Column(name = "MERCHANT")
    private String merchant;

    @Column(name = "DELETED")
    private boolean deleted = false;
}

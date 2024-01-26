package com.eshop.eshopcustomerservice.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ProductDto {
    private Long id;
    private String description;
    private double price;
    private String sku;
    private String thumbnail;
    private List<String> product_images;
    private Integer productQuantity;
    private Date productDateAvailable;
    private String region;
    private Boolean available;
    private Integer productQuantityOrderMin;
    private Integer productQuantityOrderMax;
    private List<String> categories;
    private String manufacturerId;
    private ManufacturerDto manufacturerDetails;
}

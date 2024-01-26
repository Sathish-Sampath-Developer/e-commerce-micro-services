package com.eshop.eshopcoreservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ManufacturerDto {
    private Long id;
    private String manufacturer_image;
    private String manufacturer_name;
    private String manufacturer_email;
    private String manufacturer_phone;
    private String manufacturer_address;
    private String manufacturer_code;
    private List<String> orders;
    private boolean deleted = false;
}

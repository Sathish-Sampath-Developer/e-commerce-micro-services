package com.eshop.eshopcoreservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CATEGORY")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long id;

    @Column(name = "CATEGORY_TITLE")
    private String title;

    @Column(name = "CATEGORY_STATUS")
    private boolean categoryStatus;

    @NotEmpty
    @Column(name = "CODE", length = 100, nullable = false)
    private String code;

    @Column(name = "DELETED")
    private boolean deleted = false;
}

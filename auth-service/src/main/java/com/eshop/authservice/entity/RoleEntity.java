package com.eshop.authservice.entity;

import com.eshop.authservice.enums.RoleEnum;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "ROLES")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ROLES")
    private String name;

    @Column(name = "ROLE_DESCRIPTION")
    private String roleDescription;
}

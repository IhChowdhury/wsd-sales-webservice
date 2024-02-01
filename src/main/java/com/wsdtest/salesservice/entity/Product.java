package com.wsdtest.salesservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Float price;

    @Column(length = 255)
    private String description;
}

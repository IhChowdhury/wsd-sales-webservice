package com.wsdtest.salesservice.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Entity(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cell;

    @OneToMany
    private List<Order> orders;

    @ManyToMany
    private List<Product> productWishes;
}

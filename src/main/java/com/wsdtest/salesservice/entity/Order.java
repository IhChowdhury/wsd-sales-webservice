package com.wsdtest.salesservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @OneToMany
    private List<LineProduct> lineProduct;
}

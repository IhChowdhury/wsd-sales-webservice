package com.wsdtest.salesservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity(name = "line_products")
public class LineProduct {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", nullable = false)
    private Float unitPrice;
}

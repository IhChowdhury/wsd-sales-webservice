package com.wsdtest.salesservice.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Integer id;
    private String name;
    private String description;
    private Float price;
}

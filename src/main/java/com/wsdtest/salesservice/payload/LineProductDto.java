package com.wsdtest.salesservice.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineProductDto {
    private Integer id;
    private Integer quantity;
    private Float unitPrice;
    private ProductDto product;
}

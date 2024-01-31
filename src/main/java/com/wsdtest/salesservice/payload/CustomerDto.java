package com.wsdtest.salesservice.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDto {
    private Integer id;
    private String name;
    private String cellNumber;
}

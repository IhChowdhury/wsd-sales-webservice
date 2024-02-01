package com.wsdtest.salesservice.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private Integer id;
    private String address;
    private Date orderDate;
    private List<LineProductDto> productLineList;
}

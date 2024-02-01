package com.wsdtest.salesservice.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CustomerResponse extends PageableCommonResponse{
    private List<CustomerDto> content;
}

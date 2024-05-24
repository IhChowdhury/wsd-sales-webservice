package com.wsdtest.salesservice.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponse extends PageableCommonResponse {
    private List<OrderDTO> content;
//    private int pageNo;
//    private int pageSize;
//    private long totalElements;
//    private int totalPages;
//    private boolean last = true;
}

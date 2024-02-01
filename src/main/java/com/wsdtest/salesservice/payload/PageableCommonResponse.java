package com.wsdtest.salesservice.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageableCommonResponse {
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}

package com.wsdtest.salesservice.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MaxSaleDayResponse {

    private List<MaxSaleDay> maxSaleDays = new ArrayList<>();

    @Getter
    @Setter
    @AllArgsConstructor
    public static class MaxSaleDay {
        private Date maxSaleDay;
        private Double totalSale;
    }
}

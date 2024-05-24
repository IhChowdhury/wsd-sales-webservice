package com.wsdtest.salesservice.service;

import com.wsdtest.salesservice.entity.Product;
import com.wsdtest.salesservice.payload.MaxSaleDayResponse;
import com.wsdtest.salesservice.payload.SaleAmountResponse;

import java.util.Date;
import java.util.List;

public interface SaleService {
    SaleAmountResponse getTotalSaleAmountOfTheDay(Date saleDay);

    MaxSaleDayResponse getMaxSaleDay(Date startDate, Date endDate);

    List<Product> getTop5SaleItemBasedOnTotalSale();
}

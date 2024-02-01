package com.wsdtest.salesservice.service;

import com.wsdtest.salesservice.payload.SaleAmountResponse;

import java.util.Date;

public interface SaleService {
    SaleAmountResponse getTotalSaleAmountOfTheDay(Date saleDay);
}

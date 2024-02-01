package com.wsdtest.salesservice.service;

import com.wsdtest.salesservice.payload.OrderResponse;

import java.util.Date;

public interface OrderService {
    OrderResponse getOrderListOfTheDay(Date date, int pageNo, int pageSize, String sortBy, String sortDir);
    OrderResponse getOrderListOfCustomer(int customerId, int pageNo, int pageSize, String sortBy, String sortDir);
}

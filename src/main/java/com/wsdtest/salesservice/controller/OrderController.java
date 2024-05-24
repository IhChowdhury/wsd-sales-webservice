package com.wsdtest.salesservice.controller;

import com.wsdtest.salesservice.payload.OrderResponse;
import com.wsdtest.salesservice.service.CustomerService;
import com.wsdtest.salesservice.service.OrderService;
import com.wsdtest.salesservice.utils.controller.AppConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

//    @GetMapping()
    public OrderResponse getOrderListOfTheDay(
            @RequestParam(name = "date", defaultValue = "#{new java.util.Date()}", required = false)
            @DateTimeFormat(pattern = "dd.MM.yyyy") Date orderDate,
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return orderService.getOrderListOfTheDay(orderDate, pageNo, pageSize, sortBy, sortDir);
    }

//    @GetMapping("/{customerId}")
    public OrderResponse getOrderListOfCustomer(
            @PathVariable("customerId") int customerId,
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return orderService.getOrderListOfCustomer(customerId, pageNo, pageSize, sortBy, sortDir);
    }
}

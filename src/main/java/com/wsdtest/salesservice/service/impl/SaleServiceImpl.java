package com.wsdtest.salesservice.service.impl;

import com.wsdtest.salesservice.entity.Order;
import com.wsdtest.salesservice.entity.Product;
import com.wsdtest.salesservice.payload.MaxSaleDayResponse;
import com.wsdtest.salesservice.payload.SaleAmountResponse;
import com.wsdtest.salesservice.repository.OrderRepository;
import com.wsdtest.salesservice.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {
    private final OrderRepository orderRepository;
    @Override
    public SaleAmountResponse getTotalSaleAmountOfTheDay(Date saleDay) {
        List<Order> orders = orderRepository.findAllByOrderDate(saleDay);
        double totalAmount = orders.stream().mapToDouble(order ->
                order.getLineProduct().stream().mapToDouble(lineProduct ->
                        (lineProduct.getQuantity() * lineProduct.getUnitPrice())).sum()
        ).sum();
        SaleAmountResponse saleAmountResponse = new SaleAmountResponse();
        saleAmountResponse.setTotalAmount(totalAmount);
        return saleAmountResponse;
    }

    @Override
    public MaxSaleDayResponse getMaxSaleDay(Date startDate, Date endDate) {
        List<Order> orders = orderRepository.findAllByOrderDateBetween(startDate, endDate);
        Map<Date, Double> orderDateAndTotalSaleMap = new HashMap<>();
        orders.forEach(order -> {
            double orderTotalAmount = order.getLineProduct().stream().mapToDouble(lineProduct -> lineProduct.getUnitPrice() * lineProduct.getQuantity()).sum();
            if(orderDateAndTotalSaleMap.containsKey(order.getOrderDate())) {
                orderDateAndTotalSaleMap.put(order.getOrderDate(), orderDateAndTotalSaleMap.get(order.getOrderDate()) + orderTotalAmount);
            } else {
                orderDateAndTotalSaleMap.put(order.getOrderDate(), orderTotalAmount);
            }
        });

        return getMaxSaleDayResponse(orderDateAndTotalSaleMap);
    }

    @Override
    public List<Product> getTop5SaleItemBasedOnTotalSale() {
        List<Product> top5SellingItems = orderRepository.findTop5SellingItems();
        return new ArrayList<>();
    }

    private static MaxSaleDayResponse getMaxSaleDayResponse(Map<Date, Double> orderDateAndTotalSaleMap) {
        MaxSaleDayResponse maxSaleDayResponse = new MaxSaleDayResponse();
        List<MaxSaleDayResponse.MaxSaleDay> maxSaleDays = maxSaleDayResponse.getMaxSaleDays();
        if(orderDateAndTotalSaleMap.isEmpty()){
            return maxSaleDayResponse;
        }
        Double maxValueInMap = (Collections.max(orderDateAndTotalSaleMap.values()));

        for (Map.Entry<Date, Double> entry :
                orderDateAndTotalSaleMap.entrySet()) {
            if (entry.getValue().equals(maxValueInMap)) {
                MaxSaleDayResponse.MaxSaleDay maxSaleDay = new MaxSaleDayResponse.MaxSaleDay(entry.getKey(), entry.getValue());
                maxSaleDays.add(maxSaleDay);
            }
        }
        maxSaleDayResponse.setMaxSaleDays(maxSaleDays);
        return maxSaleDayResponse;
    }

}

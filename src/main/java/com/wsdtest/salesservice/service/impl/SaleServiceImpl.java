package com.wsdtest.salesservice.service.impl;

import com.wsdtest.salesservice.entity.Order;
import com.wsdtest.salesservice.payload.SaleAmountResponse;
import com.wsdtest.salesservice.repository.OrderRepository;
import com.wsdtest.salesservice.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
}

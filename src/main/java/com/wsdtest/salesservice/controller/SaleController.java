package com.wsdtest.salesservice.controller;

import com.wsdtest.salesservice.payload.MaxSaleDayResponse;
import com.wsdtest.salesservice.payload.SaleAmountResponse;
import com.wsdtest.salesservice.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sales")
public class SaleController {
    private final SaleService saleService;

    @GetMapping("/total-amount")
    public SaleAmountResponse getSaleAmountOfTheDay(
            @RequestParam(name = "date", defaultValue = "#{new java.util.Date()}", required = false)
            @DateTimeFormat(pattern = "dd.MM.yyyy") Date saleDate
    ) {
        return saleService.getTotalSaleAmountOfTheDay(saleDate);
    }

    @GetMapping("/max-sale-day")
    public MaxSaleDayResponse getMaxSaleDay(
            @RequestParam(name = "startDate") @DateTimeFormat(pattern = "dd.MM.yyyy") Date startDate,
            @RequestParam(name = "endDate") @DateTimeFormat(pattern = "dd.MM.yyyy") Date endDate
    ) {
        return saleService.getMaxSaleDay(startDate, endDate);
    }
}

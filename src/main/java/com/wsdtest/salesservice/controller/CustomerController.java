package com.wsdtest.salesservice.controller;

import com.wsdtest.salesservice.entity.Product;
import com.wsdtest.salesservice.payload.CommonContentResponse;
import com.wsdtest.salesservice.payload.CustomerResponse;
import com.wsdtest.salesservice.service.CustomerService;
import com.wsdtest.salesservice.utils.controller.AppConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Tag(name = "Customer")
public class CustomerController {
    private final CustomerService customerService;

//    @GetMapping
    public CustomerResponse getAllRegisteredCustomers(
        @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
        @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
        @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
        @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return customerService.getAllRegisteredCustomers(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("wish-list/{customerId}")
    public CommonContentResponse getWishList(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @PathVariable(name = "customerId") Integer customerId
    ) {
        return customerService.getCustomerWishlist(customerId);
    }


}

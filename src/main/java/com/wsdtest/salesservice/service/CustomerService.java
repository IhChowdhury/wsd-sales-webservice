package com.wsdtest.salesservice.service;

import com.wsdtest.salesservice.entity.Product;
import com.wsdtest.salesservice.payload.CommonContentResponse;
import com.wsdtest.salesservice.payload.CustomerResponse;

import java.util.List;

public interface CustomerService {
    CustomerResponse getAllRegisteredCustomers(int pageNo, int pageSize, String sortBy, String sortDir);

    CommonContentResponse getCustomerWishlist(int customerId);



}

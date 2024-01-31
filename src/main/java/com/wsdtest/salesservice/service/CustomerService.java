package com.wsdtest.salesservice.service;

import com.wsdtest.salesservice.payload.CustomerResponse;

public interface CustomerService {
    CustomerResponse getAllRegisteredCustomers(int pageNo, int pageSize, String sortBy, String sortDir);
}

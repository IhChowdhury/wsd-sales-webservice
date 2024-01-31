package com.wsdtest.salesservice.service.impl;

import com.wsdtest.salesservice.entity.Customer;
import com.wsdtest.salesservice.payload.CustomerDto;
import com.wsdtest.salesservice.payload.CustomerResponse;
import com.wsdtest.salesservice.repository.CustomerRepository;
import com.wsdtest.salesservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponse getAllRegisteredCustomers(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Customer> customers = customerRepository.findAll(pageable);

        List<Customer> listOfCustomers = customers.getContent();

        List<CustomerDto> content = listOfCustomers.stream().map(this::mapToDTO).toList();

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setContent(content);
        customerResponse.setPageNo(customers.getNumber());
        customerResponse.setPageSize(customers.getSize());
        customerResponse.setTotalElements(customers.getTotalElements());
        customerResponse.setTotalPages(customers.getTotalPages());
        customerResponse.setLast(customers.isLast());

        return customerResponse;
    }

    private CustomerDto mapToDTO(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setCellNumber(customer.getCell());
        return customerDto;
    }
}

package com.wsdtest.salesservice.repository;

import com.wsdtest.salesservice.entity.Customer;
import com.wsdtest.salesservice.entity.CustomerOrder;
import com.wsdtest.salesservice.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<CustomerOrder> findAllOrderById(Integer id);
}
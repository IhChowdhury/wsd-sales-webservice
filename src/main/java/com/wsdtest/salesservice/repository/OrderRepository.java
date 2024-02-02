package com.wsdtest.salesservice.repository;

import com.wsdtest.salesservice.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Page<Order> findAllByOrderDate(Date orderDate, Pageable pageable);
    List<Order> findAllByOrderDate(Date orderDate);

    List<Order> findAllByOrderDateBetween(Date startDate, Date endDate);
}

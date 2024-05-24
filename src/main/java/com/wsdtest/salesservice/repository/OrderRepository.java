package com.wsdtest.salesservice.repository;

import com.wsdtest.salesservice.entity.Order;
import com.wsdtest.salesservice.entity.Product;
import jakarta.persistence.NamedNativeQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Page<Order> findAllByOrderDate(Date orderDate, Pageable pageable);
    List<Order> findAllByOrderDate(Date orderDate);

    List<Order> findAllByOrderDateBetween(Date startDate, Date endDate);

    @Query(value = "select p from products p where p in (select lp.product from orders o left join line_products as lp on o.lineProduct = lp group by lp.product order by sum(lp.quantity * lp.unitPrice) DESC limit 5)")
    List<Product> findTop5SellingItems();
}

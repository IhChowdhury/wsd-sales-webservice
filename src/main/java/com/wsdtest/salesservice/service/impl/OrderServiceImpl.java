package com.wsdtest.salesservice.service.impl;

import com.wsdtest.salesservice.entity.CustomerOrder;
import com.wsdtest.salesservice.entity.LineProduct;
import com.wsdtest.salesservice.entity.Order;
import com.wsdtest.salesservice.entity.Product;
import com.wsdtest.salesservice.payload.LineProductDto;
import com.wsdtest.salesservice.payload.OrderDTO;
import com.wsdtest.salesservice.payload.OrderResponse;
import com.wsdtest.salesservice.payload.ProductDto;
import com.wsdtest.salesservice.repository.CustomerRepository;
import com.wsdtest.salesservice.repository.OrderRepository;
import com.wsdtest.salesservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    @Override
    public OrderResponse getOrderListOfTheDay(Date orderDate, int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Order> orders = orderRepository.findAllByOrderDate(orderDate, pageable);
        List<Order> listOfOrders = orders.getContent();
        List<OrderDTO> content = listOfOrders.stream().map(this::entityToDTO).toList();

        OrderResponse orderResponse  = new OrderResponse();
        orderResponse.setContent(content);
        orderResponse.setPageNo(orders.getNumber());
        orderResponse.setPageSize(orders.getSize());
        orderResponse.setTotalElements(orders.getTotalElements());
        orderResponse.setTotalPages(orders.getTotalPages());
        orderResponse.setLast(orders.isLast());
        return orderResponse;
    }

    @Override
    public OrderResponse getOrderListOfCustomer(int customerId, int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Optional<CustomerOrder> customerOrders = customerRepository.findAllOrderById(customerId);
        OrderResponse orderResponse  = new OrderResponse();
        if(customerOrders.isPresent()){
            List<Order> orders = customerOrders.get().getOrders();
            Page<Order> ordersByPages = new PageImpl<Order>(orders,pageable,orders.size());
            List<OrderDTO> content = ordersByPages.getContent().stream().map(this::entityToDTO).toList();

            orderResponse.setContent(content);
            orderResponse.setPageNo(ordersByPages.getNumber());
            orderResponse.setPageSize(ordersByPages.getSize());
            orderResponse.setTotalElements(ordersByPages.getTotalElements());
            orderResponse.setTotalPages(ordersByPages.getTotalPages());
            orderResponse.setLast(ordersByPages.isLast());
        }

        return orderResponse;
    }

    private OrderDTO entityToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setAddress(order.getAddress());

        List<LineProductDto> lineProductDtoList = order.getLineProduct().stream().map(this::LineProductEntityToDTO).toList();
        orderDTO.setProductLineList(lineProductDtoList);

        return orderDTO;
    }

    private LineProductDto LineProductEntityToDTO(LineProduct lineProduct) {
        LineProductDto lineProductDto = new LineProductDto();
        lineProductDto.setId(lineProduct.getId());
        lineProductDto.setQuantity(lineProduct.getQuantity());
        lineProductDto.setUnitPrice(lineProduct.getUnitPrice());

        ProductDto productDto = productEntityToDto(lineProduct.getProduct());
        lineProductDto.setProduct(productDto);
        return lineProductDto;
    }

    private ProductDto productEntityToDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        return productDto;
    }
}

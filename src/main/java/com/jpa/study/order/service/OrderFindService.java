package com.jpa.study.order.service;

import com.jpa.study.order.domain.Order;
import com.jpa.study.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFindService {

    private final OrderRepository orderRepository;

    public OrderFindService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

}

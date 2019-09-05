package com.jpa.study.order.service;

import com.jpa.study.order.domain.Order;
import com.jpa.study.order.dto.OrderDto;
import com.jpa.study.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderCreationService {

    private final OrderRepository orderRepository;

    public OrderCreationService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order create(OrderDto.Request dto){
        return orderRepository.save(dto.toOrderEntity());
    }

}

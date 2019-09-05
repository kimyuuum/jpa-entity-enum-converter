package com.jpa.study.order.controller;

import com.jpa.study.order.dto.OrderDto;
import com.jpa.study.order.service.OrderCreationService;
import com.jpa.study.order.service.OrderFindService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderFindService orderFindService;
    private final OrderCreationService orderCreationService;

    public OrderController(OrderFindService orderFindService,
                           OrderCreationService orderCreationService) {
        this.orderFindService = orderFindService;
        this.orderCreationService = orderCreationService;
    }

    @PostMapping("")
    public OrderDto.Response create(@RequestBody @Valid OrderDto.Request dto){
        return new OrderDto.Response(orderCreationService.create(dto));
    }

    @GetMapping("")
    public List<OrderDto.Response> findAll(){
        return orderFindService.findAll()
                .stream()
                .map(OrderDto.Response::new)
                .collect(Collectors.toList());
    }

}

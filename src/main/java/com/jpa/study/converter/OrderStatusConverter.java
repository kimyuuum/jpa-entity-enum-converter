package com.jpa.study.converter;

import com.jpa.study.pojo.OrderStatus;

public class OrderStatusConverter extends AbstractLegacyEnumAttributeConverter<OrderStatus> {
    public static final String ENUM_NAME = "주문상태";
    public OrderStatusConverter(){ super (OrderStatus.class, false, ENUM_NAME); }
}

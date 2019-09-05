package com.jpa.study.order.domain;

import com.jpa.study.Address.Address;
import com.jpa.study.converter.OrderStatusConverter;
import com.jpa.study.pojo.OrderStatus;
import com.jpa.study.pojo.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "order_info")
public class Order {

    @Id
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "user_serial_number")
    private Integer userSerialNumber;

    @Column(name = "order_name")
    private String orderName;

    @Embedded
    private Address address;

    @Column(name = "order_date")
    @Type(type = "timestamp")
    @CreationTimestamp
    private Date orderDate;

    @Column(name = "order_status")
    @Convert(converter = OrderStatusConverter.class)
    private OrderStatus orderStatus;

    @Column
    private Integer amount;

    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;

}

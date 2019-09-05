package com.jpa.study.order.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jpa.study.Address.Address;
import com.jpa.study.order.domain.Order;
import com.jpa.study.pojo.OrderStatus;
import com.jpa.study.pojo.PaymentStatus;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class OrderDto {

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Request {

        @NotNull
        @JsonProperty("order_id")
        private String orderId;

        @NotNull
        @JsonProperty("user_serial_number")
        private Integer userSerialNumber;

        @JsonProperty("order_name")
        private String orderName;

        @JsonProperty("address")
        private Address address;

        @JsonProperty("order_status")
        private OrderStatus orderStatus;

        @JsonProperty("amount")
        private Integer amount;

        @JsonProperty("payment_status")
        private PaymentStatus paymentStatus;

        public Order toOrderEntity() {
            return Order.builder()
                    .orderId(orderId)
                    .userSerialNumber(userSerialNumber)
                    .orderName(orderName)
                    .address(address)
                    .orderStatus(orderStatus)
                    .amount(amount)
                    .paymentStatus(paymentStatus)
                    .build();
        }

    }

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Response {

        @JsonProperty("order_id")
        private String orderId;

        @JsonProperty("user_serial_number")
        private Integer userSerialNumber;

        @JsonProperty("order_name")
        private String orderName;

        @JsonProperty("address")
        private Address address;

        @JsonProperty("order_date")
        private Date orderDate;

        @JsonProperty("order_status")
        private OrderStatus orderStatus;

        @JsonProperty("amount")
        private Integer amount;

        @JsonProperty("payment_status")
        private PaymentStatus paymentStatus;

        public Response(Order order) {
            this.orderId = order.getOrderId();
            this.userSerialNumber = order.getUserSerialNumber();
            this.orderName = order.getOrderName();
            this.address = order.getAddress();
            this.orderDate = order.getOrderDate();
            this.orderStatus = order.getOrderStatus();
            this.amount = order.getAmount();
            this.paymentStatus = order.getPaymentStatus();
        }
    }

}

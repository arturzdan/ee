package com.accenture.flowershop.fe.dto;

import com.accenture.flowershop.fe.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDto {

    private Long id;
    private OrderStatus orderStatus;
    private Long user_id;
    private OrderDataDto orderDataDto;
    private BigDecimal value;
    private Date openData;
    private Date closeData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getOpenData() {
        return openData;
    }

    public void setOpenData(Date openData) {
        this.openData = openData;
    }

    public Date getCloseData() {
        return closeData;
    }

    public void setCloseData(Date closeData) {
        this.closeData = closeData;
    }

    public OrderDataDto getOrderDataDto() {
        return orderDataDto;
    }

    public void setOrderDataDto(OrderDataDto orderDataDto) {
        this.orderDataDto = orderDataDto;
    }
}

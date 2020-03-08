package com.accenture.flowershop.fe.dto;

import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.user.User;
import com.accenture.flowershop.fe.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDto {
    private Long id;
    private User user;
    private OrderStatus orderStatus;
    private List<OrderItemDto> order;
    private Date openDate;
    private Date closeDate;
    private int discount;
    private BigDecimal value;

    public OrderDto() {
    }

    public OrderDto(Long id, User user, OrderStatus orderStatus, List<OrderItemDto> order, Date openDate, Date closeDate, int discount, BigDecimal value) {
        this.id = id;
        this.user = user;
        this.orderStatus = orderStatus;
        this.order = order;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.discount = discount;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItemDto> getOrder() {
        return order;
    }

    public void setOrder(List<OrderItemDto> order) {
        this.order = order;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        OrderDto orderDto = (OrderDto)obj;
        Long id = orderDto.getId();
        return id.equals(this.getId());
    }
}


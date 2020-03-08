package com.accenture.flowershop.fe.dto;

public class OrderItemDto {
    private Long id;
    private FlowerDto flowerDto;
    private OrderDto orderDto;
    private int count;

    public OrderItemDto() {
    }

    public OrderItemDto(FlowerDto flower, OrderDto order, int count) {
        this.flowerDto = flower;
        this.orderDto = order;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FlowerDto getFlowerDto() {
        return flowerDto;
    }

    public void setFlowerDto(FlowerDto flowerDto) {
        this.flowerDto = flowerDto;
    }

    public OrderDto getOrderDto() {
        return orderDto;
    }

    public void setOrderDto(OrderDto orderDto) {
        this.orderDto = orderDto;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

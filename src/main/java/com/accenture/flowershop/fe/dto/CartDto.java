package com.accenture.flowershop.fe.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private FlowerDto flower;
    int countFlower;

    public CartDto(FlowerDto flower, int countFlower) {
        this.flower = flower;
        this.countFlower = countFlower;
    }

    public FlowerDto getFlower() {
        return flower;
    }

    public void setFlower(FlowerDto flower) {
        this.flower = flower;
    }

    public int getCountFlower() {
        return countFlower;
    }

    public void setCountFlower(int countFlower) {
        this.countFlower = countFlower;
    }
}

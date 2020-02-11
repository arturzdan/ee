package com.accenture.flowershop.fe.dto;

import java.util.HashMap;
import java.util.Map;

public class OrderDataDto {
    private Map<FlowerDto, Integer> mapFlower = new HashMap<>();

    public Map<FlowerDto, Integer> getMapFlower() {
        return mapFlower;
    }

    public void setMapFlower(Map<FlowerDto, Integer> mapFlower) {
        this.mapFlower = mapFlower;
    }
}

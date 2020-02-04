package com.accenture.flowershop.fe.dto;

import com.accenture.flowershop.be.entity.flower.Flowers;
import java.math.BigDecimal;

public class FlowerDto {
    private Long id;
    private String name;
    private int count;
    private BigDecimal value;

    FlowerDto adapter(Flowers flower) {
        this.id = flower.getId();
        this.name = flower.getName();
        this.count = flower.getCount();
        this.value = flower.getValue();
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}

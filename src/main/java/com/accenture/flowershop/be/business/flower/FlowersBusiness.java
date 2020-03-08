package com.accenture.flowershop.be.business.flower;

import com.accenture.flowershop.be.entity.flower.Flower;

import java.math.BigDecimal;
import java.util.List;

public interface FlowersBusiness {

    public Flower getFlowers(Long id);

    public List<Flower> getAllFlowers();

    public List<Flower> getAllFlowers(String name, BigDecimal min, BigDecimal max);
}

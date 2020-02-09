package com.accenture.flowershop.be.business.flower;

import com.accenture.flowershop.be.entity.flower.Flowers;

import java.util.List;

public interface FlowersBusiness {

    public Flowers getFlowers(Long id);

    public List<Flowers> getAllFlowers();
}

package com.accenture.flowershop.be.business.flower;

import com.accenture.flowershop.be.access.flower.FlowersAccess;

import com.accenture.flowershop.be.entity.flower.Flowers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowersBusinessImpl implements FlowersBusiness {

    @Autowired
    private FlowersAccess flowersAccess;

    @Override
    public Flowers getFlowers(Long id) {
        return flowersAccess.getFlowers(id);
    }

    @Override
    public List<Flowers> getAllFlowers() {
        return flowersAccess.getAllFlowers();
    }
}

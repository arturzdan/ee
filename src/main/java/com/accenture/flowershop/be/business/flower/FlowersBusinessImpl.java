package com.accenture.flowershop.be.business.flower;

import com.accenture.flowershop.be.access.flower.FlowersAccess;

import com.accenture.flowershop.be.entity.flower.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlowersBusinessImpl implements FlowersBusiness {

    @Autowired
    private FlowersAccess flowersAccess;

    @Override
    public Flower getFlowers(Long id) {
        return flowersAccess.getFlowers(id);
    }

    @Override
    public List<Flower> getAllFlowers() {
        return flowersAccess.getAllFlowers();
    }

    @Override
    public List<Flower> getAllFlowers(String name, BigDecimal min, BigDecimal max) {
        List<Flower> flowersList = new ArrayList<>();
        for (Flower it : flowersAccess.getAllFlowers()
        ) {
            String nameFlower = it.getName();
            BigDecimal value = it.getValue();
            if (!nameFlower.contains(name))
                continue;
            if (value.compareTo(min) >= 0 && value.compareTo(max) <= 0)
                flowersList.add(it);
        }
        return flowersList;
    }
}


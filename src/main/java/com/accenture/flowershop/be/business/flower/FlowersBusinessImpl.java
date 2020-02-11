package com.accenture.flowershop.be.business.flower;

import com.accenture.flowershop.be.access.flower.FlowersAccess;

import com.accenture.flowershop.be.entity.flower.Flowers;
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
    public Flowers getFlowers(Long id) {
        return flowersAccess.getFlowers(id);
    }

    @Override
    public List<Flowers> getAllFlowers() {
        return flowersAccess.getAllFlowers();
    }

    @Override
    public List<Flowers> getAllFlowers(String name, BigDecimal min, BigDecimal max) {
        List<Flowers> flowersList = new ArrayList<>();
        for (Flowers it : flowersAccess.getAllFlowers()
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


package com.accenture.flowershop.be.access.flower;

import com.accenture.flowershop.be.entity.flower.Flower;
import java.util.List;

public interface FlowersAccess {

    void addFlowers(Flower flowers);

    void removeFlowers(Flower flowers);

    void updateFlower(Flower flowers);

    Flower getFlowers(Long id);

    List<Flower> getAllFlowers();
}

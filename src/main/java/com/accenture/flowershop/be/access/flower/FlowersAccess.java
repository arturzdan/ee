package java.com.accenture.flowershop.be.access.flower;

import java.com.accenture.flowershop.be.entity.flower.Flowers;
import java.util.List;

interface FlowersAccess {

    void addFlowers(Flowers flowers);

    void removeFlowers(Flowers flowers);

    void updateFlower(Flowers flowers);

    Flowers getFlowers(Long id);

    List<Flowers> getAllFlowers();
}

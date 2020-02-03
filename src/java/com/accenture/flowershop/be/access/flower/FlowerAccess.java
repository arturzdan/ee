package java.com.accenture.flowershop.be.access.flower;

import java.com.accenture.flowershop.be.entity.flower.Flowers;
import java.util.List;

interface FlowesAccess {
    void addFlowers(Flowers order);

    void deleteFlowers(Long id);

    void updateFlower(Flowers order);

    Flowers getFlower(Long id);

    List<Flowers> getAllFlower();
}

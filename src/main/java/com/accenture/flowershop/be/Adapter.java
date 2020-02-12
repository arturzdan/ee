package com.accenture.flowershop.be;

import com.accenture.flowershop.be.entity.flower.Flowers;
import com.accenture.flowershop.fe.dto.FlowerDto;

public class Adapter {

    public static Flowers DtoToFlowers(FlowerDto flowerDto) {
        if (flowerDto == null)
            return null;
        Flowers flowers = new Flowers();
        flowers.setId(flowerDto.getId());
        flowers.setName(flowerDto.getName());
        flowers.setCount(flowerDto.getCount());
        flowers.setValue(flowerDto.getValue());
        return flowers;
    }

    public static FlowerDto FlowersToDto(Flowers flowers) {
        if (flowers == null)
            return null;
        FlowerDto flowerDto = new FlowerDto();
        flowerDto.setId(flowers.getId());
        flowerDto.setName(flowers.getName());
        flowerDto.setCount(flowers.getCount());
        flowerDto.setValue(flowers.getValue());
        return flowerDto;
    }

}

package com.accenture.flowershop.be;

import com.accenture.flowershop.be.entity.flower.Flowers;
import com.accenture.flowershop.fe.dto.FlowerDto;

import java.util.ArrayList;
import java.util.List;

public class AdapterFlower {

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

    public static List<Flowers> dtoToFlowers(List<FlowerDto> dtoList) {
        List<Flowers> flowersList = new ArrayList<>();
        for (FlowerDto it : dtoList)
            flowersList.add(AdapterFlower.DtoToFlowers(it));
        return flowersList;
    }

    public static List<FlowerDto> flowersToDto(List<Flowers> flowersList) {
        List<FlowerDto> dtoList = new ArrayList<>();
        for (Flowers it : flowersList)
            dtoList.add(AdapterFlower.FlowersToDto(it));
        return dtoList;
    }
}

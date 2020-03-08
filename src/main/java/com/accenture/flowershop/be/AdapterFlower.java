package com.accenture.flowershop.be;

import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.fe.dto.FlowerDto;

import java.util.ArrayList;
import java.util.List;

public class AdapterFlower {

    public static Flower DtoToFlowers(FlowerDto flowerDto) {
        if (flowerDto == null)
            return null;
        Flower flowers = new Flower();
        flowers.setId(flowerDto.getId());
        flowers.setName(flowerDto.getName());
        flowers.setCount(flowerDto.getCount());
        flowers.setValue(flowerDto.getValue());
        return flowers;
    }

    public static FlowerDto FlowersToDto(Flower flowers) {
        if (flowers == null)
            return null;
        FlowerDto flowerDto = new FlowerDto();
        flowerDto.setId(flowers.getId());
        flowerDto.setName(flowers.getName());
        flowerDto.setCount(flowers.getCount());
        flowerDto.setValue(flowers.getValue());
        return flowerDto;
    }

    public static List<Flower> dtoToFlowers(List<FlowerDto> dtoList) {
        List<Flower> flowersList = new ArrayList<>();
        for (FlowerDto it : dtoList)
            flowersList.add(AdapterFlower.DtoToFlowers(it));
        return flowersList;
    }

    public static List<FlowerDto> flowersToDto(List<Flower> flowersList) {
        List<FlowerDto> dtoList = new ArrayList<>();
        for (Flower it : flowersList)
            dtoList.add(AdapterFlower.FlowersToDto(it));
        return dtoList;
    }
}

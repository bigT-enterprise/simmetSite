package com.bigt.simmet.models.dtos;

import com.bigt.simmet.models.enums.Condition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopItemDto {

    private String name;

    private int nom_number;

    private String manufacturer;

    private String model;

    private Condition condition;

    private String location;

    private String description;

    private int category;

    public ShopItemDto() {
    }
}

package com.bigt.simmet.models.mappers;

import com.bigt.simmet.models.ShopItem;
import com.bigt.simmet.models.dtos.ShopItemDto;
import org.springframework.stereotype.Component;

@Component
public class ShopItemMapper {

    public ShopItem fromDto(ShopItemDto dto){
        return new ShopItem(dto.getName(),
                dto.getNom_number(),
                dto.getManufacturer(),
                dto.getModel(),
                dto.getCondition(),
                dto.getLocation(),
                dto.getDescription());
    }

}

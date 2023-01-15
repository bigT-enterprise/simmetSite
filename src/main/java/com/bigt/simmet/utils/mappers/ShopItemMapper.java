package com.bigt.simmet.utils.mappers;

import com.bigt.simmet.models.ShopItem;
import com.bigt.simmet.models.dtos.ShopItemDto;
import com.bigt.simmet.repositories.contracts.ItemCategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class ShopItemMapper {
    private final ItemCategoryRepository repository;

    public ShopItemMapper(ItemCategoryRepository repository) {
        this.repository = repository;
    }

    public ShopItem fromDto(ShopItemDto dto) {
        return ShopItem.builder()
                .name(dto.getName())
                .nom_number(dto.getNom_number())
                .manufacturer(dto.getManufacturer())
                .model(dto.getModel())
                .condition(dto.getCondition())
                .location(dto.getLocation())
                .description(dto.getDescription())
                .category(repository.findById(dto.getCategory()).orElseThrow())
                .build();
    }

}

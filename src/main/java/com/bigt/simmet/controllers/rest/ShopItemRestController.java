package com.bigt.simmet.controllers.rest;

import com.bigt.simmet.models.ShopItem;
import com.bigt.simmet.models.dtos.ShopItemDto;
import com.bigt.simmet.services.contracts.ShopItemService;
import com.bigt.simmet.utils.mappers.ShopItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/items")
public class ShopItemRestController {

    private final ShopItemService service;
    private final ShopItemMapper mapper;

    @Autowired
    public ShopItemRestController(ShopItemService service,
                                  ShopItemMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ShopItem> getAll() {
        return service.getAllItems();
    }

    @GetMapping("/{id}")
    public ShopItem getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public void createShopItem(@RequestBody ShopItemDto dto) {
        service.createItem(mapper.fromDto(dto));
    }
}

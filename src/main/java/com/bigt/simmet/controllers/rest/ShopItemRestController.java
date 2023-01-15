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

    @GetMapping("/id/{id}")
    public ShopItem getById(@PathVariable int id){
        return service.getById(id);
    }

    @GetMapping("/name/{name}")
    public ShopItem getByName(@PathVariable String name) {return service.getByName(name);}

    @PostMapping("/create")
    public void createShopItem(@RequestBody ShopItemDto dto){
        service.createItem(mapper.fromDto(dto));
    }

    @PutMapping("/update/{id}")
    public ShopItem updateShopItem(@PathVariable int id, @RequestBody ShopItemDto dto) {
        ShopItem item = mapper.fromDto(dto);
        item.setId(id);
        return service.updateItem(item);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteShopItem(@PathVariable int id) {
        service.deleteItem(service.getById(id));
    }
}

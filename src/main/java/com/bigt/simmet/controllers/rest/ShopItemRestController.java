package com.bigt.simmet.controllers.rest;

import com.bigt.simmet.models.ShopItem;
import com.bigt.simmet.models.dtos.ShopItemDto;
import com.bigt.simmet.services.contracts.ShopItemService;
import com.bigt.simmet.utils.exceptions.EntityIsNullException;
import com.bigt.simmet.utils.exceptions.NoSuchEntityException;
import com.bigt.simmet.utils.mappers.ShopItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public ShopItem getById(@PathVariable int id) {
        try {
            return service.getById(id);
        } catch (
                NoSuchEntityException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/name/{name}")
    public ShopItem getByName(@PathVariable String name) {
        try {
            return service.getByName(name);
        } catch (NoSuchEntityException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/create")
    public void createShopItem(@RequestBody ShopItemDto dto) {
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
        try {
            service.deleteItem(service.getById(id));
        } catch (NoSuchEntityException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (EntityIsNullException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        }
    }
}

package com.bigt.simmet.services;

import com.bigt.simmet.models.Category;
import com.bigt.simmet.models.ShopItem;
import com.bigt.simmet.repositories.contracts.ShopItemRepository;
import com.bigt.simmet.services.contracts.ShopItemService;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopItemServiceImpl implements ShopItemService {

    private ShopItemRepository repository;

    @Autowired
    public ShopItemServiceImpl(ShopItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ShopItem> getAllItems() {
        return repository.findAll();
    }

    // Todo implement this method
    @Override
    public List<ShopItem> getAllByCategory(Category category) {
        return null;
    }

    @Override
    public ShopItem getById(int id) {
            return repository.getReferenceById(id);
    }

    @Override
    public ShopItem getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void createItem(ShopItem item) {
        repository.saveAndFlush(item);
    }

    @Override
    public ShopItem updateItem(ShopItem item) {
        return repository.saveAndFlush(item);
    }

    @Override
    public void deleteItem(ShopItem item) {
        repository.delete(item);
    }
}

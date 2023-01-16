package com.bigt.simmet.services;

import com.bigt.simmet.models.Category;
import com.bigt.simmet.models.ShopItem;
import com.bigt.simmet.repositories.contracts.ShopItemRepository;
import com.bigt.simmet.services.contracts.ShopItemService;
import com.bigt.simmet.utils.exceptions.EntityIsNullException;
import com.bigt.simmet.utils.exceptions.NoSuchEntityException;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopItemServiceImpl implements ShopItemService {

    private final ShopItemRepository repository;

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
        try {
            return repository.getReferenceById(id);
        } catch (EntityNotFoundException e) {
            throw new NoSuchEntityException("ShopItem with " + id + "does not exist");
        }
    }

    @Override
    public ShopItem getByName(String name) {
        try {
            return repository.findByName(name);
        } catch (EntityNotFoundException e) {
            throw new NoSuchEntityException("ShopItem with " + name + "does not exist");
        }
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
        try {
        repository.delete(item);
        } catch (OptimisticEntityLockException e) {
            throw new NoSuchEntityException("The ShopItem you are trying to delete does not exist!");
        } catch (IllegalArgumentException e) {
            throw new EntityIsNullException("You are trying to delete a null ShopItem");
        }
    }
}

package com.bigt.simmet.services.contracts;

import com.bigt.simmet.models.Category;
import com.bigt.simmet.models.ShopItem;
import com.bigt.simmet.repositories.contracts.ShopItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShopItemService {
    List<ShopItem> getAllItems();

    List<ShopItem> getAllByCategory(Category category);

    ShopItem getById(int id);

    ShopItem getByName(String name);

    void createItem(ShopItem item);

    ShopItem updateItem(ShopItem item);

    void deleteItem(ShopItem item);

}

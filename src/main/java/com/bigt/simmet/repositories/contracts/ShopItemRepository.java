package com.bigt.simmet.repositories.contracts;

import com.bigt.simmet.models.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopItemRepository extends JpaRepository<ShopItem, Integer> {
}

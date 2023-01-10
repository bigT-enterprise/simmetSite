package com.bigt.simmet.repositories.contracts;

import com.bigt.simmet.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCategoryRepository extends JpaRepository<Category, Integer> {
}

package com.bigt.simmet.repositories.contracts;

import com.bigt.simmet.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Integer> {
    Service findByName(String name);
}

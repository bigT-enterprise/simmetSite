package com.bigt.simmet.services.contracts;

import com.bigt.simmet.models.Category;
import com.bigt.simmet.models.Service;
import com.bigt.simmet.models.ShopItem;

import java.util.List;

public interface ServicesService {
    List<Service> getAllServices();

    Service getById(int id);

    Service getByName(String name);

    void createService(Service item);

    Service updateService(Service item);

    void deleteService(Service item);
}

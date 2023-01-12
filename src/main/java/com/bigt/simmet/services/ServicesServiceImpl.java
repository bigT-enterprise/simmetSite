package com.bigt.simmet.services;

import com.bigt.simmet.models.Service;
import com.bigt.simmet.repositories.contracts.ServiceRepository;
import com.bigt.simmet.services.contracts.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServicesServiceImpl implements ServicesService {

    private final ServiceRepository repository;

    @Autowired
    public ServicesServiceImpl(ServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Service> getAllServices() {
        return repository.findAll();
    }

    @Override
    public Service getById(int id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Service getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void createService(Service item) {
        repository.saveAndFlush(item);
    }

    @Override
    public Service updateService(Service item) {
        return repository.saveAndFlush(item);
    }

    @Override
    public void deleteService(Service item) {
        repository.delete(item);
    }
}

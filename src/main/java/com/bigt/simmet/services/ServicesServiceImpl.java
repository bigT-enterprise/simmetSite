package com.bigt.simmet.services;

import com.bigt.simmet.models.Service;
import com.bigt.simmet.repositories.contracts.ServiceRepository;
import com.bigt.simmet.services.contracts.ServicesService;
import com.bigt.simmet.utils.exceptions.EntityIsNullException;
import com.bigt.simmet.utils.exceptions.NoSuchEntityException;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.dialect.lock.OptimisticEntityLockException;
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
        try {
        return repository.getReferenceById(id);
        } catch (EntityNotFoundException e){
            throw new NoSuchEntityException("Service with " + id + "does not exist");
        }
    }

    @Override
    public Service getByName(String name) {
        try {
            return repository.findByName(name);
        } catch (EntityNotFoundException e){
            throw new NoSuchEntityException("Service with " + name + "does not exist");
        }
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
        try {
            repository.delete(item);
        } catch (OptimisticEntityLockException e) {
            throw new NoSuchEntityException("The Service you are trying to delete does not exist!");
        } catch (IllegalArgumentException e) {
            throw new EntityIsNullException("You are trying to delete a null Service");
        }
    }
}

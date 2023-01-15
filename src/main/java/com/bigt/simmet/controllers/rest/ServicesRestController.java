package com.bigt.simmet.controllers.rest;

import com.bigt.simmet.models.Service;
import com.bigt.simmet.models.dtos.ServiceDto;
import com.bigt.simmet.models.mappers.ServiceMapper;
import com.bigt.simmet.services.contracts.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/services")
public class ServicesRestController {
    private final ServicesService service;

    private final ServiceMapper mapper;

    @Autowired
    public ServicesRestController(ServicesService service, ServiceMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<Service> getAll() {
        return service.getAllServices();
    }

    @GetMapping("/id/{id}")
    public Service getById(@PathVariable int id) {
        return service.getById(id);
    }

    @GetMapping("/name/{name}")
    public Service getByName(@PathVariable String name) {
        return service.getByName(name);
    }

    @PostMapping("/create")
    public void createService(@RequestBody ServiceDto dto) {
        service.createService(mapper.fromDto(dto));
    }

    @PutMapping("/update/{id}")
    public Service updateService(@PathVariable int id, @RequestBody ServiceDto dto) {
        Service serviceToUpdate = mapper.fromDto(dto);
        serviceToUpdate.setId(id);
        return service.updateService(serviceToUpdate);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteService(@PathVariable int id) {
        service.deleteService(service.getById(id));
    }
}

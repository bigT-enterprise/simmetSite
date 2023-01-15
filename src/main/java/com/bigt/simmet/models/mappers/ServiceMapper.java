package com.bigt.simmet.models.mappers;

import com.bigt.simmet.models.Service;
import com.bigt.simmet.models.dtos.ServiceDto;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper {
    public Service fromDto(ServiceDto dto) {
        return new Service(dto.getName(), dto.getDescription());
    }
}

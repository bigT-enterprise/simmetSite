package com.bigt.simmet.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceDto {

    private String name;

    private String description;

    public ServiceDto(){
    }

    public ServiceDto(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

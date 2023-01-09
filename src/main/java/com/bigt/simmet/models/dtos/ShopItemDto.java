package com.bigt.simmet.models.dtos;

import com.bigt.simmet.models.Category;
import com.bigt.simmet.models.enums.Condition;

public class ShopItemDto {

    private String name;

    private int nom_number;

    private String manufacturer;

    private String model;

    private Condition condition;

    private String location;

    private String description;

    private Category category;

    public ShopItemDto(){}

    public ShopItemDto(String name,
                       int nom_number,
                       String manufacturer,
                       String model,
                       Condition condition,
                       String location,
                       String description,
                       Category category) {
        this.name = name;
        this.nom_number = nom_number;
        this.manufacturer = manufacturer;
        this.model = model;
        this.condition = condition;
        this.location = location;
        this.description = description;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNom_number() {
        return nom_number;
    }

    public void setNom_number(int nom_number) {
        this.nom_number = nom_number;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

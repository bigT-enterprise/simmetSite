package com.bigt.simmet.models;

import com.bigt.simmet.models.enums.Condition;
import jakarta.persistence.*;

@Entity(name = "ShopItem")
@Table(name = "shop_items")
public class ShopItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "nom_number")
    private int nom_number;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "model")
    private String model;

    @Column(name = "condition")
    private Condition condition;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category")
    private Category category;

    public ShopItem(String name,
                    int nom_number,
                    String manufacturer,
                    String model,
                    Condition condition,
                    String location,
                    String description) {
        this.name = name;
        this.nom_number = nom_number;
        this.manufacturer = manufacturer;
        this.model = model;
        this.condition = condition;
        this.location = location;
        this.description = description;
    }

    public ShopItem(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}

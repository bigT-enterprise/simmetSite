package com.bigt.simmet.models;

import com.bigt.simmet.models.enums.Condition;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity(name = "ShopItem")
@Table(name = "shop_items")
public class ShopItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "nom_number")
    private int nom_number;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "model")
    private String model;

    @Column(name = "enum_condition")
    private Condition condition;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category")
    private Category category;

    public ShopItem(String name,
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
}

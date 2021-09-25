package com.joonseolee.bookgrek.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Item {

    private @Id String id;
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Item(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

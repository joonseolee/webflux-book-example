package com.joonseolee.bookgrek.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
@Setter
public class Dish {

    private String description;
    private boolean delivered;

    public static Dish deliver(Dish dish) {
        return new Dish(dish.getDescription(), true);
    }
}

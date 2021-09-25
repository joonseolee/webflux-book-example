package com.joonseolee.bookgrek.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {

    private Item item;
    private int quantity;

    public CartItem(Item item) {
        this.item = item;
        this.quantity = 1;
    }
}

package com.joonseolee.bookgrek.model;

import org.springframework.data.annotation.Id;

import java.util.Collections;
import java.util.List;

public class Cart {

    private @Id String id;
    private List<CartItem> cartItems;

    public Cart(String id) {
        this.id = id;
        this.cartItems = Collections.emptyList();
    }

    public Cart(String id, List<CartItem> cartItems) {
        this.id = id;
        this.cartItems = cartItems;
    }
}

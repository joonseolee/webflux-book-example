package com.joonseolee.bookgrek.repository;

import com.joonseolee.bookgrek.model.Cart;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CartRepository extends ReactiveCrudRepository<Cart, String> {
}

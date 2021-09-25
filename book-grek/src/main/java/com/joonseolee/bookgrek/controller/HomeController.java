package com.joonseolee.bookgrek.controller;

import com.joonseolee.bookgrek.model.Cart;
import com.joonseolee.bookgrek.model.CartItem;
import com.joonseolee.bookgrek.model.Item;
import com.joonseolee.bookgrek.repository.CartRepository;
import com.joonseolee.bookgrek.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final MongoTemplate mongoTemplate;
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    @GetMapping("/home")
    public Mono<Rendering> homed() {
        return Mono.just(Rendering.view("home")
                .modelAttribute("items", mongoTemplate.findAll(Item.class, "items"))
                .modelAttribute("cart", new Cart("EKRNVKVB", Collections.singletonList(new CartItem(new Item("dffe", 49.2934)))))
                .build());
    }

    @PostMapping("/add/{id}")
    public Mono<String> addToCart(@PathVariable String id) {
        return this.cartRepository.findById("My Cart")
                .defaultIfEmpty(new Cart("My Cart"))
                .flatMap(cart -> cart.getCartItems().stream()
                        .filter(cartItem -> cartItem.getItem().getId().equals(id))
                .findAny()
                .map(cartItem -> {
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                    return Mono.just(cart);
                })
                .orElseGet(() -> this.itemRepository.findById(id)
                        .map(CartItem::new)
                        .map(cartItem -> {
                            cart.getCartItems().add(cartItem);
                            return cart;
                        })))
                .flatMap(this.cartRepository::save)
                .thenReturn("redirect:/");
    }

//    @GetMapping("/home")
//    public String home(Model model) {
//        model.addAttribute("items", mongoTemplate.findAll(Item.class, "items"));
//        return "home";
//    }
}

package com.joonseolee.bookgrek.controller;

import com.joonseolee.bookgrek.model.Cart;
import com.joonseolee.bookgrek.model.CartItem;
import com.joonseolee.bookgrek.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final MongoTemplate mongoTemplate;

    @GetMapping("/home")
    public Mono<Rendering> homed() {
        return Mono.just(Rendering.view("home")
                .modelAttribute("items", mongoTemplate.findAll(Item.class, "items"))
                .modelAttribute("cart", new Cart("EKRNVKVB", Collections.singletonList(new CartItem(new Item("dffe", 49.2934)))))
                .build());
    }

//    @GetMapping("/home")
//    public String home(Model model) {
//        model.addAttribute("items", mongoTemplate.findAll(Item.class, "items"));
//        return "home";
//    }
}

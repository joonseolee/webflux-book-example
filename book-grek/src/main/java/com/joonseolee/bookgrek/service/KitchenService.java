package com.joonseolee.bookgrek.service;

import com.joonseolee.bookgrek.model.Dish;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service//
public class KitchenService {

    private final List<Dish> menu = Arrays.asList(
            new Dish("Sesame chicken", false),
            new Dish("Sweet sour beef", false),
            new Dish("Lo mein noodles, plain", false)
    );
    private final Random picker = new Random();

    public Flux<Dish> getDishes() {
        return Flux.<Dish>generate(sink -> sink.next(randomDish()))
                .delayElements(Duration.ofMillis(250));
    }

    private Dish randomDish() {
        return menu.get(picker.nextInt(menu.size()));
    }
}

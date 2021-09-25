package com.joonseolee.bookgrek.controller;

import com.joonseolee.bookgrek.bo.SimpleServerBO;
import com.joonseolee.bookgrek.model.Dish;
import com.joonseolee.bookgrek.service.KitchenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
public class SimpleServerController {

    private final SimpleServerBO simpleServerBO;
    private final KitchenService kitchenService;

    @GetMapping(value = "dishes", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Dish> getDishes() {
        return kitchenService.getDishes();
    }

    @GetMapping(value = "served-dishes", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Dish> getDeliveredDishes() {
        return kitchenService.getDishes().map(Dish::deliver);
    }
}

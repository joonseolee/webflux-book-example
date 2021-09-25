package com.joonseolee.bookgrek.bo;

import com.joonseolee.bookgrek.model.Dish;
import com.joonseolee.bookgrek.service.KitchenService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SimpleServerBOTest {

    @InjectMocks
    private SimpleServerBO simpleServerBO;

    @Mock
    private KitchenService kitchenService;

    @Test
    void heelel() {
        when(kitchenService.getDishes()).thenReturn(Flux.just(
                new Dish("Sesame chicken"),
                new Dish("Lo mein noodles, plain"),
                new Dish("Sweet sour beef")));
        Flux<Dish> dishes = simpleServerBO.doingMyJob();

        dishes
                .doOnNext(dish -> {
                    assertThat(dish.getMenu(), containsString("prdoceeding"));
                })
                .doOnNext(dish -> {
                    dish.setMenu("ee");
                    System.out.println(dish.getMenu());
                });
    }
}
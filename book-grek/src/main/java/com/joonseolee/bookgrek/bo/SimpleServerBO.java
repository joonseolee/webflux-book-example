package com.joonseolee.bookgrek.bo;

import com.joonseolee.bookgrek.model.Dish;
import com.joonseolee.bookgrek.service.KitchenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@RequiredArgsConstructor
@Service
public class SimpleServerBO {

    private final KitchenService kitchenService;

    public Flux<Dish> doingMyJob() {
        return this.kitchenService.getDishes().map(Dish::deliver);
    }
}

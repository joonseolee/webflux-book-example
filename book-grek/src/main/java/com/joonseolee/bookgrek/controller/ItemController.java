package com.joonseolee.bookgrek.controller;

import com.joonseolee.bookgrek.model.Item;
import com.joonseolee.bookgrek.service.BlockingItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ItemController {

    private final BlockingItemService blockingItemService;
    private final MongoTemplate mongoTemplate;

    @GetMapping("items")
    public List<Item> getItems() {
        mongoTemplate.save(new Item("Alf alarm clock", 19.99));
        mongoTemplate.save(new Item("Smurf TV tray", 24.99));
        return mongoTemplate.findAll(Item.class);
    }
}

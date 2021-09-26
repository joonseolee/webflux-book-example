package com.joonseolee.bookgrek.service;

import com.joonseolee.bookgrek.model.Item;
//import com.joonseolee.bookgrek.repository.ItemByExampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class ItemService {

//    private final ItemByExampleRepository itemByExampleRepository;
//
//    public Flux<Item> searchByExample(String name, String description, boolean useAnd) {
//        var item = new Item(name, description, 0.0);
//
//        ExampleMatcher matcher = (useAnd
//            ? ExampleMatcher.matchingAll()
//            : ExampleMatcher.matchingAny())
//                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
//                .withIgnoreCase()
//                .withIgnorePaths("price");
//
//        Example<Item> probe = Example.of(item, matcher);
//
//        return itemByExampleRepository.findAll(probe);
//    }
}

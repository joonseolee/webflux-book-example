package com.joonseolee.bookgrek.service;

import com.joonseolee.bookgrek.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class BlockingItemService {

//    private final BlockingItemRepository blockingItemRepository;
//
//    public List<Item> findAll() {
//        return StreamSupport.stream(blockingItemRepository.findAll().spliterator(), false)
//                .collect(Collectors.toList());
//    }
//
//    public Item save(Item item) {
//        return blockingItemRepository.save(item);
//    }
}

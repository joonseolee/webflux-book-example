package com.joonseolee.bookgrek.repository;

import com.joonseolee.bookgrek.model.Item;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface ItemByExampleRepository extends ReactiveQueryByExampleExecutor<Item> {
}

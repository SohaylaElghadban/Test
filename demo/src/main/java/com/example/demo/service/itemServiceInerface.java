package com.example.demo.service;

import com.example.demo.model.Item;

import java.util.List;
import java.util.Optional;

public interface itemServiceInerface {
    Item addItem(Item item);

    List<Item> getAllItems();

    Optional<Item> GetItemById(long id);
    boolean deleteItemById(long id);
}

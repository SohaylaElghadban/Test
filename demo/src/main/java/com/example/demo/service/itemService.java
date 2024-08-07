package com.example.demo.service;
import com.example.demo.model.Item;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class itemService implements itemServiceInerface {
    private List<Item> items = new ArrayList<Item>() {{
        add(new Item(1, "Item1", "Item1 is here"));
        add(new Item(2, "Item2", "Item2 is here"));
        add(new Item(3, "Item3", "Item3 is here"));
    }};
    private long ID = 1;

@Override
    public Item addItem(Item item) {
        this.items.add(item);
        return item;
    }
    @Override
    public  List<Item> getAllItems() {
        return new ArrayList<>(items);
    }

    @Override
    public Optional<Item> GetItemById(long id) {
        return items.stream().filter(item -> item.getID().equals(ID)).findFirst();
    }
    @Override
    public boolean deleteItemById(long id) {
    return items.removeIf(item -> item.getID() == id);

    }

}
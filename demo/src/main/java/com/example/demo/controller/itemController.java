package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.service.itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/items")
public class itemController {
    @Autowired
    private itemService itemService;

    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        Item itemx = itemService.addItem(item);
        return ResponseEntity.ok(itemx);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Item> GetItemById(@PathVariable Long id) {
        return itemService.GetItemById(id).map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());

    }
    @GetMapping
    public ResponseEntity<List<Item>> GetAllItems() {

        return ResponseEntity.ok(itemService.getAllItems());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Item> DeleteItemById(@PathVariable Long id) {
        return  itemService.deleteItemById(id)? ResponseEntity.ok().build():ResponseEntity.notFound().build();
    }
}

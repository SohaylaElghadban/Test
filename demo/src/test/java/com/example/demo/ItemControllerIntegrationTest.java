package com.example.demo;

import com.example.demo.model.Item;
import com.example.demo.service.itemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private itemService ItemService;

    @Test
    public void testAddItem() throws Exception {
        Item item1 = new Item(1, "Item1", "Item1 is here");
        when(ItemService.addItem(any(Item.class))).thenReturn(item1);
        mockMvc.perform(post("/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"ID\": 1, \"Name\": \"Item1\", \"Code\": \"Item1 is here\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Item1"))
                .andExpect(jsonPath("$.code").value("Item1 is here"));
    }

    @Test
    public void testGetItemById() throws Exception {
        Item item = new Item(1, "Item1", "Item1 is here");

        when(ItemService.GetItemById(1)).thenReturn(Optional.of(item));

        mockMvc.perform(get("/items/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Item1"))
                .andExpect(jsonPath("$.code").value("Item1 is here"));
    }

    @Test
    public void testGetAllItems() throws Exception {
        Item item1 = new Item(1, "Item1", "Item1 is here");
        Item item2 = new Item(2, "Item2", "Item2 is here");
        when(ItemService.getAllItems()).thenReturn(Arrays.asList(item1, item2));

        mockMvc.perform(get("/items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Item1"))
                .andExpect(jsonPath("$[0].code").value("Item1 is here"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Item2"))
                .andExpect(jsonPath("$[1].code").value("Item2 is here"));
    }

    @Test
    public void testDeleteItemById() throws Exception {
        when(ItemService.deleteItemById(1)).thenReturn(true);

        mockMvc.perform(delete("/items/1"))
                .andExpect(status().isOk());
    }
}

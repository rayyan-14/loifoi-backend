package com.example.loifoi.controller;

import com.example.loifoi.model.Item;
import com.example.loifoi.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        System.out.println("Item received: " + item);
        return itemRepository.save(item);
    }

    @GetMapping("/pending")
    public List<Item> getPendingItems() {
        return itemRepository.findByApproved(false);
    }

    @PutMapping("/approve/{id}")
    public Item approveItem(@PathVariable Long id) {
        Item item = itemRepository.findById(id).orElseThrow();
        item.setApproved(true);
        item.setTimestamp(LocalDateTime.now());
        return itemRepository.save(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
    }

    @GetMapping("/approved")
    public List<Item> getApprovedItems() {
        LocalDateTime cutoff = LocalDateTime.now().minusDays(30);
        return itemRepository.findByApprovedIsTrueAndTimestampAfter(cutoff);
    }
}

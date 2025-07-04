package com.example.loifoi.scheduler;

import com.example.loifoi.repository.ItemRepository;
import com.example.loifoi.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ItemCleanupScheduler {

    @Autowired
    private ItemRepository itemRepository;

    // Runs every day at 12:00 AM
    @Scheduled(cron = "0 0 12 * * ?")
    public void deleteOldItems() {
        LocalDateTime cutoffDate = LocalDateTime.now().minusDays(1);
        List<Item> allItems = itemRepository.findAll();

        for (Item item : allItems) {
            if (item.getTimestamp().isBefore(cutoffDate)) {
                itemRepository.delete(item);
            }
        }
        System.out.println("Old items cleanup completed at: " + LocalDateTime.now());
    }
}

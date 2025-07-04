package com.example.loifoi.repository;

import com.example.loifoi.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByApproved(boolean approved);
    List<Item> findByApprovedIsTrueAndTimestampAfter(LocalDateTime time);
}

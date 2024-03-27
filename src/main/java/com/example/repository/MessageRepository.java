package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Message;
import java.util.*;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    // @Query("SELECT messages FROM messages WHERE posted_by")
    // List<Message> findByUsername(Integer posted_by);
}

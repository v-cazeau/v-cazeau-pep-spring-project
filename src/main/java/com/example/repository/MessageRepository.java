package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Message;
// import java.util.*;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query(value = "SELECT messages FROM messages WHERE posted_by = ?1", nativeQuery = true)
    Message findByUsername(Integer posted_by);
}

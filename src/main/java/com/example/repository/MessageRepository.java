package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Message;
import java.util.*;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    // @Query("FROM message WHERE posted_by = :posted_by")
    // List<Message> getMessagesByAccountId(@Param("posted_by") int posted_by);
}

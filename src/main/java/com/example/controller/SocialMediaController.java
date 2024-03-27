package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Message;
import com.example.service.AccountService;
import com.example.service.MessageService;

import java.util.*; 

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */

 @Controller
 @RequestMapping("")
public class SocialMediaController {

    private AccountService accountService;
    private MessageService messageService;

    public void AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public void MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    // #4 retrieve all messages.
    @GetMapping("messages")
    public @ResponseBody List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    // #5 retrieve a message by its ID.
    @GetMapping("messages/{message_id}")
    public ResponseEntity<Message> MessageById(@PathVariable int message_id) {
        Message messages = messageService.getMessageById(message_id);
        return ResponseEntity.ok()
            .body(message);
    }

    // //#6 delete a message identified by a message ID.

    // @DeleteMapping("messages/{message_id}")
    // public @ResponseBody ResponseEntity<
}

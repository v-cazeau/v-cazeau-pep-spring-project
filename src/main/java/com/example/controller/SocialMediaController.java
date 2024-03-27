package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.exception.ResourceNotFoundException;

import javax.naming.AuthenticationException;
import com.example.service.AccountService;
import com.example.service.MessageService;

import java.util.*;

import javax.websocket.server.PathParam; 

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */

 @RestController
public class SocialMediaController {

    public AccountService accountService;
    public MessageService messageService;

    @Autowired
    public void AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    public void MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    // #1 process new User registrations.
    // @PostMapping("register")
    // public @ResponseBody ResponseEntity<?> register(@RequestBody Account account) throws ResourceNotFoundException, Exception {
    //     try {
    //         Account registeredAccount = accountService.register(account);
    //         return ResponseEntity.ok(registeredAccount);
    //     } catch (ResourceNotFoundException e) {
            
    //         return ResponseEntity.badRequest().body("Invalid username or password.");
    //     } catch (Exception e) {

    //         return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists.");
    //     }
        
    // }


    // #2 process User logins.
    // @PostMapping("login")
    // public @ResponseBody ResponseEntity<Void> login(@RequestBody Account account) throws AuthenticationException {
    //     accountService.login(account.getUsername(), account.getPassword());
    //     return ResponseEntity.noContent()
    //         .header("username", account.getUsername())
    //         .build();
    // }

    // #3 process the creation of new messages.
    @PostMapping("messages")
    public @ResponseBody ResponseEntity<Message> addNewMessage(@RequestBody Message newMessage) {
        Message createdMessage = messageService.addNewMessage(newMessage);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(createdMessage);
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
            .body(messages);
    }

    //#6 delete a message identified by a message ID.

    @DeleteMapping("messages/{message_id}")
    public ResponseEntity<?> deleteMessage(@PathVariable int message_id) {
        boolean deleted = messageService.deleteMessage(message_id); 
        if (deleted) {
            return ResponseEntity.ok()
                .body(1);
        } else {
            return ResponseEntity.ok()
                .body(null);
        }
    }

    // #7 update a message text identified by a message ID.

    // @PatchMapping("messages/{message_id}")
    // public @ResponseBody ResponseEntity<String> updateMessage( @RequestBody Message updatedMessage) {
    //     messageService.updateMessage(updatedMessage);
    //     return ResponseEntity.ok()
    //             .body("Message successfully updated.");
    //     }

    // #8 retrieve all messages written by a particular user.
    
    // @GetMapping("accounts/{account_id}/messages")
    // public @ResponseBody ResponseEntity<List<Message>> getAllMessagesByUser(@PathVariable int account_id) {
    //     List<Message> messagesByUser = messageService.getAllMessagesByUser(account_id); //add @query to repo
    //     return ResponseEntity.ok()
    //             .body(getAllMessages());
    // }
}

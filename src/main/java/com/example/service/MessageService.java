package com.example.service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class MessageService {

    public MessageRepository messageRespository; 

    @Autowired
    public MessageService(MessageRepository messageRespository) {
        this.messageRespository = messageRespository;
    }

    // private List<Message> messages = new ArrayList<>();

    //#3 process the creation of new messages.
    public Message addNewMessage(Message newMessage) {
        if (!messageRespository.existsById(newMessage.getPosted_by()) || newMessage.getMessage_text().length() > 255 || newMessage.getMessage_text().isBlank()) {
            return null;
        }
        return messageRespository.save(newMessage);
    }
    
    // #4 retrieve all messages.
    public List<Message> getAllMessages() {
        return messageRespository.findAll();
    }

    // #5 retrieve a message by its ID.
    public Message getMessageById(int message_id) {
        Optional<Message> messageById = messageRespository.findById(message_id);
         if (messageById.isPresent()) {
                return messageById.get();
            } else {
                return null;
            }
    }

    // #6 delete a message identified by a message ID.
    public boolean deleteMessage(int message_id) {
        if (messageRespository.existsById(message_id)){
            messageRespository.deleteById(message_id);
            return true;
        }
        return false;
    }

    // #7 update a message text identified by a message ID. (PATCH)
    public Integer updateMessage(Integer message_id, Message messageUpdate) {
        Optional<Message> existingMessage = messageRespository.findById(message_id);

        if (!existingMessage.isPresent()) {
            return 0;
        }
        if (messageUpdate != null && messageUpdate.getMessage_text().isBlank()) {
            return 0;
        }
        if (messageUpdate.getMessage_text().length() > 255) {
            return 0;
        }
        Message message = existingMessage.get();
        message.setMessage_text(messageUpdate.getMessage_text());
        messageRespository.save(message);
        return 1;

    }

    // #8 retrieve all messages written by a particular user.
    public List<Message> getAllMessagesByUser(int posted_by) {
        return messageRespository.getMessagesByAccountId(posted_by);
    
        }

}

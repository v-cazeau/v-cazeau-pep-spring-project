package com.example.service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;
import com.example.exception.ResourceNotFoundException;

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

    private List<Message> messages = new ArrayList<>();

    //#3 process the creation of new messages.
    public Message addNewMessage(Message newMessage) {
        messages.add(newMessage);
        return newMessage;
    }
    
    // #4 retrieve all messages.
    public List<Message> getAllMessages() {
        return messages;
    }

    // #5 retrieve a message by its ID.
    public Message getMessageById(int message_id) throws ResourceNotFoundException {
        for (Message message:messages) {
            if (message.getMessage_id().equals(message_id)) {
                return message;
            }
        }
        throw new ResourceNotFoundException(message_id + "was not found.");
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
    public Message updateMessage(Integer message_id, Integer posted_by, String message_text, Long time_posted_epoch) throws ResourceNotFoundException {
        for (Message message:messages) {
            if (message.getMessage_id().equals(message_id)){
                if (message_text.length() >= 255 && !message_text.isBlank());
                return message;
            }
        }
        throw new ResourceNotFoundException(message_id + "was not found. Please check id provided or try another.");

    }

    // #8 retrieve all messages written by a particular user.
    public List<Message> getAllMessagesByUser(int message_id) throws ResourceNotFoundException {
       return getAllMessagesByUser(message_id);
        }

}

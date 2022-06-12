package org.revature.revbook.service;

import org.revature.revbook.data.MessageRepository;
import org.revature.revbook.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

// MessageService Class
// This class will handle the business logic for the Message objects in the application.
@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    // AddMessage method
    // This method will insert a new Message object into the database as a record:
    public Message addMessage(Message message){
        // Add the current time to the createdAt for message:
        message.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

        // Call MessageRepository to save the modified message:
        messageRepository.save(message);
        return message;
    }

    // GetAllMessages method
    // This method will retrieve the List of Message objects from the database:
    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }

    // GetMessageById method
    // This method will get a specific Message object from the database with the supplied id:
    public Message getMessageById(Long messageId) {
        return messageRepository.findById(messageId).get();
    }

    // GetAllMessagesByRecipientId method
    // This method will retrieve List of Messages from the database by calling the MessageRepository and using the
    //  findByRecipientId method which will supply the recipientId to the method:
    public List<Message> getAllMessagesByRecipientId(Long recipientId) {
        return messageRepository.findByRecipientId(recipientId);
    }

    // UpdateMessage method
    // This method will update a record in the database by the specified id:
    public Message updateMessage(Message message, Long messageId) {
        // Retrieve the database Message object from the database that matches the id:
        Message messageDB = messageRepository.findById(messageId).get();

        // Set the database Message's attributes to the supplied Message object's attributes:
        messageDB.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        messageDB.setMessageContent(message.getMessageContent());

        // Update the record in the database through the MessageRepository's save method:
        messageRepository.save(messageDB);
        return messageDB;
    }

    // DeleteMessage method
    // This method will delete a record from the database by the specified id:
    public void deleteMessage(Long messageId) {
        messageRepository.deleteById(messageId);
    }
}


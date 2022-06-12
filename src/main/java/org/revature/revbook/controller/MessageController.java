package org.revature.revbook.controller;

import org.revature.revbook.entity.Message;
import org.revature.revbook.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// MessageController Class
// This class will handle the HTTP Requests for the API/resource paths associated with the Message objects.
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/messages")
public class MessageController {

    @Autowired
    MessageService messageService;

    // PostMapping to add a Message to the database:
    @PostMapping("")
    public Message addMessage(@RequestBody Message message) {
        return messageService.addMessage(message);
    }

    // GetMapping to retrieve a specific Message object from the database:
    @GetMapping("/{messageId}")
    public Message getMessageById(@PathVariable("messageId") Long messageId) {
        return messageService.getMessageById(messageId);
    }

    // GetMapping to retrieve Message objects for a specified Recipient from the database:
    @GetMapping("/recipient/{recipientId}")
    public List<Message> getAllMessagesByRecipientId(@PathVariable("recipientId") Long recipientId) {
        return messageService.getAllMessagesByRecipientId(recipientId);
    }

    // GetMapping to retrieve Message objects from the database:
    @GetMapping("")
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    // PutMapping to update a specified Message record with the supplied JSON Message object in the database:
    @PutMapping("/{messageId}")
    public Message updateMessage(@PathVariable("messageId") Long messageId, @RequestBody Message message) {
        return messageService.updateMessage(message, messageId);
    }

    // DeleteMapping to delete a specified Message record from the database:
    @DeleteMapping("/{messageId}")
    public void deleteComment(@PathVariable("messageId") Long messageId) {
        messageService.deleteMessage(messageId);
    }
}

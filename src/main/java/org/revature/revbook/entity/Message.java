package org.revature.revbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

// Lombok annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Message {

    // Data members for the Message object:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String messageContent;
    @Column(nullable = false)
    private Long senderId;
    @Column(nullable = false)
    private Long recipientId;

    // Constructor without ID:
    public Message(Timestamp createdAt, Timestamp updatedAt, String messageContent, Long senderId, Long recipientId) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.messageContent = messageContent;
        this.senderId = senderId;
        this.recipientId = recipientId;
    }

}

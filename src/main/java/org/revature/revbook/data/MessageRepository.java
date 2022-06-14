package org.revature.revbook.data;

import org.revature.revbook.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// MessageRepository Interface Class
// This interface class will handle the data logic of the Message objects in the database for the application.
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    public List<Message> findByRecipientUserId(Long recipientId);
}

package org.revature.revbook.data;

import org.revature.revbook.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// CommentRepository Interface Class
// This interface class will handle the data logic of the Comment objects in the database for the application.
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    public List<Comment> findByPostId(Long postId);
}

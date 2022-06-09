package org.revature.revbook.service;

import java.util.List;

import org.revature.revbook.data.CommentRepository;
import org.revature.revbook.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public Comment postComment(Comment comment){
        System.out.println(comment.getParentId());
        commentRepository.save(comment);
        return comment;
    }

    public List<Comment> get_all_comments() {
        return commentRepository.findAll();
    }

    public Comment get_by_id(long id) {
        return commentRepository.findById(id).get();
    }

    public void delete_comment(Long id) {
        commentRepository.deleteById(id);
    }
}

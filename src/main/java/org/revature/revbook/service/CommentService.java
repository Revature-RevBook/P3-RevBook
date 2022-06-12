package org.revature.revbook.service;

import java.util.Iterator;
import java.util.LinkedList;
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

    public List<Comment> get_comments(long id) {
        List<Comment> comments = commentRepository.findAll();
        List<Comment> res = new LinkedList<Comment>();
        Iterator< Comment > iterator = comments.iterator();

        while(iterator.hasNext()) {
            Comment c = iterator.next();
            if(c.getPostId() == id && c.getParentId() == null)
                res.add(c);
        }
        return res;
    }

    public Comment get_by_id(long id) {
        return commentRepository.findById(id).get();
    }

    public void delete_comment(Long id) {
        commentRepository.deleteById(id);
    }
}

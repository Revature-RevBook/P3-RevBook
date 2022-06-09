package org.revature.revbook.controller;

import java.util.List;

import org.revature.revbook.entity.Comment;
import org.revature.revbook.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> getAll(){
        return commentService.get_all_comments();
    }

    @PostMapping
    public Comment post(@RequestBody Comment comment){
        System.out.println("Posting comment");
        return commentService.postComment(comment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Long id){
        commentService.delete_comment(id);
    }
    
}

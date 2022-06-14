package org.revature.revbook.controller;

import org.revature.revbook.entity.SubComment;
import org.revature.revbook.service.SubCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// SubCommentController Class
// This class will handle the HTTP Requests for the API/resource paths associated with the SubComment objects.
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/sub-comments")
public class SubCommentController {
    @Autowired
    SubCommentService subCommentService;

    // PostMapping to add a SubComment to the database:
    @PostMapping("")
    public SubComment addSubComment(@RequestBody SubComment subComment) {
        return subCommentService.addSubComment(subComment);
    }

    // GetMapping to retrieve a specific SubComment object from the database:
    @GetMapping("/{subCommentId}")
    public SubComment getSubCommentById(@PathVariable("subCommentId") Long subCommentId) {
        return subCommentService.getSubCommentById(subCommentId);
    }

    // GetMapping to retrieve SubComment objects for a specified Comment from the database:
    @GetMapping("/comment/{commentId}")
    public List<SubComment> getAllSubCommentsByCommentId(@PathVariable("commentId") Long commentId) {
        return subCommentService.getAllSubCommentsByCommentId(commentId);
    }

    // GetMapping to retrieve SubComment objects from the database:
    @GetMapping("")
    public List<SubComment> getAllSubComments() {
        return subCommentService.getAllSubComments();
    }

    // PutMapping to update a specified SubComment record with the supplied JSON SubComment object in the database:
    @PutMapping("/{subCommentId}")
    public SubComment updateSubComment(@PathVariable("subCommentId") Long subCommentId, @RequestBody SubComment subComment) {
        return subCommentService.updateSubComment(subComment, subCommentId);
    }

    // DeleteMapping to delete a specified SubComment record from the database:
    @DeleteMapping("/{subCommentId}")
    public void deleteSubComment(@PathVariable("subCommentId") Long subCommentId) {
        subCommentService.deleteSubComment(subCommentId);
    }
}
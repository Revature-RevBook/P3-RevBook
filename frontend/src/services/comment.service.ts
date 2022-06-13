import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Comment } from 'src/entity/comment';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http:HttpClient) { }

  addComment(comment:Partial<Comment>) {
    return this.http.post<Comment>('http://localhost:8080/comments', comment);
  }

  getAllComments() {
    return this.http.get<Comment[]>('http://localhost:8080/comments');
  }

  getCommentById(commentId:Number) {
    return this.http.get<Comment>(`http://localhost:8080/comments/${commentId}`);
  }

  getAllCommentsByPostId(postId:Number) {
    return this.http.get<Comment[]>(`http://localhost:8080/comments/post/${postId}`);
  }

  updateComment(comment:Comment) {
    return this.http.put<Comment>(`http://localhost:8080/comments/${comment.commentId}`, comment);
  }

  deleteComment(commentId:Number) {
    return this.http.delete(`http://localhost:8080/comments/${commentId}`);
  }
}

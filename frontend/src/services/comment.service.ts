import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Comment } from 'src/entity/comment';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http:HttpClient) { }

  addComment(comment:Partial<Comment>) {
    return this.http.post<Comment>('http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/comments', comment);
  }

  getAllComments() {
    return this.http.get<Comment[]>('http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/comments');
  }

  getCommentById(commentId:Number) {
    return this.http.get<Comment>(`http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/comments/${commentId}`);
  }

  getAllCommentsByPostId(postId:Number) {
    return this.http.get<Comment[]>(`http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/comments/post/${postId}`);
  }

  updateComment(comment:Comment) {
    return this.http.put<Comment>(`http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/comments/${comment.commentId}`, comment);
  }

  deleteComment(commentId:Number) {
    return this.http.delete(`http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/comments/${commentId}`);
  }
}

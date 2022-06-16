import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SubComment } from 'src/entity/sub-comment';

@Injectable({
  providedIn: 'root'
})
export class SubCommentService {

  constructor(private http:HttpClient) { }

  addSubComment(subComment:Partial<SubComment>) {
    return this.http.post<SubComment>('http://localhost:8080/sub-comments', subComment);
  }

  getAllSubComments() {
    return this.http.get<SubComment[]>('http://localhost:8080/sub-comments');
  }

  getSubCommentById(commentId:Number) {
    return this.http.get<SubComment>(`http://localhost:8080/sub-comments/${commentId}`);
  }

  getAllSubCommentsByCommentId(commentId:Number) {
    return this.http.get<SubComment[]>(`http://localhost:8080/sub-comments/comment/${commentId}`);
  }

  updateSubComment(subComment:SubComment) {
    return this.http.put<SubComment>(`http://localhost:8080/sub-comments/${subComment.subCommentId}`, subComment);
  }

  deleteSubComment(subCommentId:Number) {
    return this.http.delete(`http://localhost:8080/sub-comments/${subCommentId}`);
  }
}

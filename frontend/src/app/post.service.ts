import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Post } from './post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http:HttpClient) { }

  createPost(post:Partial<Post>){
    return this.http.post<Post>('http://localhost:8080/posts', post);
  }

  getAllPosts() {
    return this.http.get<Post[]>('http://localhost:9001/posts');
  }

  getPostById(id:Number) {
    return this.http.get<Post>(`http://localhost:9001/posts/${id}`);
  }

  updatePost(post:Post) {
    return this.http.put<Post>(`http://localhost:9001/posts/${post.id}`,post);
  }

  deletePost(id:Number) {
    return this.http.delete(`http://localhost:9001/posts/${id}`);
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Post } from 'src/entity/post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http:HttpClient) { }

  addPost(post:Partial<Post>) {
    return this.http.post<any>('http://localhost:8080/posts', post);
  }

  getAllPosts() {
    return this.http.get<Post[]>('http://localhost:8080/posts');
  }
}

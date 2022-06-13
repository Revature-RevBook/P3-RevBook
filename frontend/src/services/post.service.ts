import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Post } from 'src/entity/post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http:HttpClient) { }

  addPost(post:Partial<Post>) {
    return this.http.post<any>('http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/posts', post);
  }

  getAllPosts() {
    return this.http.get<Post[]>('http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/posts');
  }
}

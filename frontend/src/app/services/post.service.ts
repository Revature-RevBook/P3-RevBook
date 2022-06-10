import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Post } from '../post';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http:HttpClient) { }

  // API url
  baseApiUrl = "https://file.io"

  // Returns an observable
  upload(file:any):Observable<any> {
  
      // Create form data
      const formData = new FormData(); 
        
      // Store form name as "file" with file data
      formData.append("file", file, file.name);
        
      // Make http post request over api
      // with formData as req
      return this.http.post(this.baseApiUrl, formData)
  }

  createPost(post:Partial<Post>){
    return this.http.post<Post>('http://localhost:8080/posts', post);
  }

  getAllPosts() {
    return this.http.get<Post[]>('http://localhost:8080/posts');
  }

  getPostById(id:Number) {
    return this.http.get<Post>(`http://localhost:8080/posts/${id}`);
  }

  updatePost(post:Post) {
    return this.http.put<Post>(`http://localhost:8080/posts/`,post);
  }

  deletePost(id:Number) {
    return this.http.delete(`http://localhost:8080/posts/${id}`);
  }
}

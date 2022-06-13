import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PostImageService {

  constructor(private http:HttpClient) { }

  addImage(postId:Number, file:File) {
    const formData = new FormData();

    formData.append("file", file, file.name);

    return this.http.post<any>('http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/post-images/' + postId, formData);
  }
}

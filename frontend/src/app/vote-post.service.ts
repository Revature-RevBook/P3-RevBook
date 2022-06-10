import { Post } from './post';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { VotePost } from './vote-post';

@Injectable({
  providedIn: 'root'
})
export class VotePostService {
  
  constructor(private http:HttpClient) { }

  createVotePost(votePost:Partial<VotePost>){
    return this.http.post<VotePost>('http://localhost:8080/votes', votePost);
  }

  getAllVotePostsByPostId() {
    return this.http.get<VotePost[]>('http://localhost:8080/votes');
  }

  getVotePostByPostId(id:Number) {
    return this.http.get<VotePost>(`http://localhost:8080/votes/${id}`);
  }

  updateVotePost(votePost:VotePost) {
    return this.http.put<VotePost>(`http://localhost:8080/votes/`,votePost);
  }

  deleteVotePost(id:Number) {
    return this.http.delete(`http://localhost:8080/votes/${id}`);
  }
}

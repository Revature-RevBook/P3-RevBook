import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { VotePost } from 'src/entity/vote-post';

@Injectable({
  providedIn: 'root'
})
export class VotePostService {

  constructor(private http:HttpClient) { }

  addVotePost(votePost:Partial<VotePost>) {
    return this.http.post<VotePost>('http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/vote-posts', votePost);
  }

  getAllVotePosts() {
    return this.http.get<VotePost[]>('http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/vote-posts');
  }

  getVotePostById(voteId:Number) {
    return this.http.get<VotePost>(`http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/vote-posts/${voteId}`);
  }

  getAllVotesPostByPostId(postId:Number) {
    return this.http.get<VotePost[]>(`http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/vote-posts/post/${postId}`);
  }

  updateVotePost(votePost:VotePost) {
    return this.http.put<VotePost>(`http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/vote-posts/${votePost.voteId}`, votePost);
  }

  deleteVotePost(votePostId:Number) {
    return this.http.delete(`http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/vote-posts/${votePostId}`);
  }
}

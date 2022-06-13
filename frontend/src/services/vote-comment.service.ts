import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { VoteComment } from 'src/entity/vote-comment';

@Injectable({
  providedIn: 'root'
})
export class VoteCommentService {

  constructor(private http:HttpClient) { }

  addVoteComment(voteComment:Partial<VoteComment>) {
    return this.http.post<VoteComment>('http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/vote-comments', voteComment);
  }

  getAllVoteComments() {
    return this.http.get<VoteComment[]>('http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/vote-comments');
  }

  getVoteCommentById(voteId:Number) {
    return this.http.get<VoteComment>(`http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/vote-comments/${voteId}`);
  }

  getAllVoteCommentsByVoterId(voterId:Number) {
    return this.http.get<VoteComment[]>(`http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/vote-comments/voter/${voterId}`);
  }

  getAllVoteCommentsByCommentId(commentId:Number) {
    return this.http.get<VoteComment[]>(`http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/vote-comments/comment/${commentId}`);
  }

  updateVoteComment(voteComment:VoteComment) {
    return this.http.put<VoteComment>(`http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/vote-comments/${voteComment.voteId}`, voteComment);
  }

  deleteVoteComment(voteId:Number) {
    return this.http.delete(`http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/vote-comments/${voteId}`);
  }
}

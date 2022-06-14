import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { VoteComment } from 'src/entity/vote-comment';

@Injectable({
  providedIn: 'root'
})
export class VoteCommentService {

  constructor(private http:HttpClient) { }

  addVoteComment(voteComment:Partial<VoteComment>) {
    return this.http.post<VoteComment>('http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/vote-comments', voteComment);
  }

  getAllVoteComments() {
    return this.http.get<VoteComment[]>('http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/vote-comments');
  }

  getVoteCommentById(voteId:Number) {
    return this.http.get<VoteComment>(`http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/vote-comments/${voteId}`);
  }

  getAllVoteCommentsByVoterId(voterId:Number) {
    return this.http.get<VoteComment[]>(`http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/vote-comments/voter/${voterId}`);
  }

  getAllVoteCommentsByCommentId(commentId:Number) {
    return this.http.get<VoteComment[]>(`http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/vote-comments/comment/${commentId}`);
  }

  updateVoteComment(voteComment:VoteComment) {
    return this.http.put<VoteComment>(`http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/vote-comments/${voteComment.voteId}`, voteComment);
  }

  deleteVoteComment(voteId:Number) {
    return this.http.delete(`http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/vote-comments/${voteId}`);
  }
}

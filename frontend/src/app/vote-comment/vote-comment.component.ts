import { Component, Input, OnInit } from '@angular/core';
import { VoteComment } from 'src/entity/vote-comment';
import { VoteCommentService } from 'src/services/vote-comment.service';

@Component({
  selector: 'app-vote-comment',
  templateUrl: './vote-comment.component.html',
  styleUrls: ['./vote-comment.component.css']
})
export class VoteCommentComponent implements OnInit {
  @Input() commentId:Number = 0;

  time = new Date();

  counter:number = 0;

  voteComment:Partial<VoteComment> = {
    createdAt: this.time,
    vote: 0,
    commentId: 0,
    voterId: 0
  }

  voteComments!:VoteComment[];

  constructor(private voteCommentService:VoteCommentService) { }

  ngOnInit(): void {
    this.getVotes();
  }

  getVotes() {
    this.counter = 0;
    this.voteCommentService.getAllVoteCommentsByCommentId(this.commentId).subscribe((voteComments:VoteComment[]) => {
      this.voteComments = voteComments;
      for(let x = 0; x < this.voteComments.length; x++) {
        this.counter += voteComments[x].vote;
      }
    });
  }

  incrementVoteComment() {
    // Get the user for the session:
    let currentUserId = Number(sessionStorage.getItem('userId'));

    // Check to see if the user has already upvoted:
    for(let x=0; x < this.voteComments.length; x++) {
      if(this.voteComments[x].voterId == currentUserId && this.voteComments[x].vote == 1) {
        return;
      }
    }

    // Check to see if the user has voted already, but downvoted instead:
    for(let x = 0; x < this.voteComments.length; x++) {
      if(this.voteComments[x].voterId == currentUserId && this.voteComments[x].vote == -1) {
        this.voteComments[x].vote = 1;

        // Call the VoteCommentService to update the vote:
        this.voteCommentService.updateVoteComment(this.voteComments[x]).subscribe(res => {
          // Refresh the comments:
          this.getVotes();
        })
        return;
      }
    }

    // Else, create a new VoteComment and call the VoteCommentService to send the object to the database:
    this.voteComment.vote = 1;
    this.voteComment.commentId = this.commentId;
    this.voteComment.voterId = currentUserId;

    this.voteCommentService.addVoteComment(this.voteComment).subscribe(res => {
      // Refresh the comments:
      this.getVotes();
    })
  }

  decrementVoteComment() {
    // Get the user for the session:
    let currentUserId = Number(sessionStorage.getItem('userId'));

    // Check to see if the user has already upvoted:
    for(let x = 0; x < this.voteComments.length; x++) {
      if(this.voteComments[x].voterId == currentUserId && this.voteComments[x].vote == -1) {
        return;
      }
    }

    // Check to see if the user has voted already, but upvoted instead:
    for(let x = 0; x < this.voteComments.length; x++) {
      if(this.voteComments[x].voterId == currentUserId && this.voteComments[x].vote == 1) {
        this.voteComments[x].vote = -1;

        // Call the VoteCommentService to update the vote:
        this.voteCommentService.updateVoteComment(this.voteComments[x]).subscribe(res => {
          // Refresh the comments:
          this.getVotes();
        })
        return;
      }
    }

    // Else, create a new VoteComment and call the VoteCommentService to send the object to the database:
    this.voteComment.vote = -1;
    this.voteComment.commentId = this.commentId;
    this.voteComment.voterId = currentUserId;

    this.voteCommentService.addVoteComment(this.voteComment).subscribe(res => {
      // Refresh the comments:
      this.getVotes();
    })
  }

}
import { Component, Input, OnInit } from '@angular/core';
import { VotePost } from 'src/entity/vote-post';
import { VotePostService } from 'src/services/vote-post.service';

@Component({
  selector: 'app-vote-post',
  templateUrl: './vote-post.component.html',
  styleUrls: ['./vote-post.component.css']
})
export class VotePostComponent implements OnInit {
  @Input() postId:Number = 0;

  time = new Date();

  counter:number = 0;

  votePost:Partial<VotePost> = {
    createdAt: this.time,
    vote: 0,
    postId: 0,
    voterId: 0
  }

  votePosts!:VotePost[];

  constructor(private votePostService:VotePostService) { }

  ngOnInit(): void {
    this.getVotes();
  }

  getVotes() {
    this.counter = 0;
    this.votePostService.getAllVotesPostByPostId(this.postId).subscribe((votePosts:VotePost[]) => {
      this.votePosts = votePosts;
      for(let x = 0; x < this.votePosts.length; x++) {
        this.counter += votePosts[x].vote;
      }
    });
  }

  incrementVotePost() {
    // Get the user for the session:
    let currentUserId = Number(sessionStorage.getItem('userId'));

    // Check to see if user already upvoted:
    for(let x = 0; x < this.votePosts.length; x++) {
      if(this.votePosts[x].voterId == currentUserId && this.votePosts[x].vote == 1) {
        return;
      }
    }

    // Check to see if user already voted, but downvoted instead:
    for(let x = 0; x < this.votePosts.length; x++) {
      if(this.votePosts[x].voterId == currentUserId && this.votePosts[x].vote == -1) {
        this.votePosts[x].vote = 1;

        // Call VotePostService to update the vote:
        this.votePostService.updateVotePost(this.votePosts[x]).subscribe(res => {
          // Refresh the posts:
          this.getVotes();
        })
        return;
      }
    }

    // Else, create a new votePost and call the VotePostService to send the object to the database:
    this.votePost.vote = 1;
    this.votePost.postId = this.postId;
    this.votePost.voterId = currentUserId;

    this.votePostService.addVotePost(this.votePost).subscribe(res => {
      if(res) {
        // Refresh the posts:
        this.getVotes();
      }
    });
  }

  decrementVotePost() {
    // Get the user for the session:
    let currentUserId = Number(sessionStorage.getItem('userId'));

    // Check to see if user already upvoted:
    for(let x = 0; x < this.votePosts.length; x++) {
      if(this.votePosts[x].voterId == currentUserId && this.votePosts[x].vote == -1) {
        return;
      }
    }

    // Check to see if user already voted, but upvoted instead:
    for(let x = 0; x < this.votePosts.length; x++) {
      if(this.votePosts[x].voterId == currentUserId && this.votePosts[x].vote == 1) {
        this.votePosts[x].vote = -1;

        // Call VotePostService to update the vote:
        this.votePostService.updateVotePost(this.votePosts[x]).subscribe(res => {
          // Refresh the posts:
          this.getVotes();
        })
        return;
      }
    }

    // Else, create a new votePost and call the VotePostService to send the object to the database:
    this.votePost.vote = -1;
    this.votePost.postId = this.postId;
    this.votePost.voterId = currentUserId;

    this.votePostService.addVotePost(this.votePost).subscribe(res => {
      if(res) {
        // Refresh the posts:
        this.getVotes();
      }
    });
  }
}

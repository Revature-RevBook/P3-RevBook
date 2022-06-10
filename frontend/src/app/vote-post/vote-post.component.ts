import { Post } from './../post';
import { VotePostService } from './../vote-post.service';
import { Component, OnInit } from '@angular/core';
import { VotePost } from '../vote-post';
import { Post } from '../post';
import { timeStamp } from 'console';

@Component({
  selector: 'app-vote-post',
  templateUrl: './vote-post.component.html',
  styleUrls: ['./vote-post.component.css']
})
export class VotePostComponent implements OnInit {

  votePost!: VotePost;
  post!: Post;

  constructor(private votePostService:VotePostService) { }

  ngOnInit(): void {
    //I need a way to pass in the post this votePost is associated with
    this.votePost = this.getVotePostByPostId(this.post);
  }

  addVotePost(post:Post){
    this.votePost.post_id = post.post_id;
    //this.votePost.voter_id = post.poster_id;
    this.votePost.created_at = new Date();

    this.votePostService.createVotePost(this.votePost).subscribe((votePost:VotePost)=>{
      console.log(votePost);
    })
  }

   getVotePostByPostId(post:Post) : any{
    this.votePostService.getVotePostByPostId(post.post_id!).subscribe((votePost:VotePost)=>{
      return votePost;
      console.log(votePost);
    })
  }

  incrementVotePost(){
    this.votePost.vote++;

    this.votePostService.updateVotePost(this.votePost).subscribe((votePost:VotePost)=>{
      console.log(votePost);
    })
  }

  decrementVotePost(){
    this.votePost.vote--;

    this.votePostService.updateVotePost(this.votePost).subscribe((votePost:VotePost)=>{
      console.log(votePost);
    })
  }
}

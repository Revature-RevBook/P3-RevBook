import { CreatePostComponent } from './../create-post/create-post.component';
import { Post } from './../post';
import { VotePostService } from './../vote-post.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { VotePost } from '../vote-post';

@Component({
  selector: 'app-vote-post',
  templateUrl: './vote-post.component.html',
  styleUrls: ['./vote-post.component.css']
})
export class VotePostComponent implements OnInit {

  votePost!: VotePost;
  post!: Partial<Post>;

  constructor(private votePostService:VotePostService) { }

  ngOnInit(): void {
    
  }

  createVotePost(post: Partial<Post>){
    this.post = post
    this.votePost.post_id = this.post.post_id;
    this.votePost.created_at = new Date();

    this.votePostService.createVotePost(this.votePost).subscribe((votePost:VotePost)=>{
      console.log(votePost);
    })
  }

  getVotePostByPostId() : any{
    this.votePostService.getVotePostByPostId(this.post.post_id!).subscribe((votePost:VotePost)=>{
      return votePost;
    })
  }

  incrementVotePost(){
    this.votePost.vote++;
    this.votePost.updated_at = new Date();

    this.votePostService.updateVotePost(this.votePost).subscribe((votePost:VotePost)=>{
      console.log(votePost);
    })
  }

  decrementVotePost(){
    this.votePost.vote--;
    this.votePost.updated_at = new Date();

    this.votePostService.updateVotePost(this.votePost).subscribe((votePost:VotePost)=>{
      console.log(votePost);
    })
  }
}

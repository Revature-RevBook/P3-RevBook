import { VotePostComponent } from './../vote-post/vote-post.component';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Post } from '../post'
import { PostService } from '../post.service';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent implements OnInit {

  @ViewChild(VotePostComponent)
  private votePostComponent!: VotePostComponent;

  post!: Partial<Post>;

  constructor(private postService: PostService) { }

  ngOnInit(): void {
    this.post = {
        post_title: '',
        post_content: '',
        post_img: ''
    }
  }

  createPost() {
    this.postService.createPost(this.post).subscribe((post: Partial<Post>) => {
        this.post = post;
      })

      this.votePostComponent.createVotePost(this.post);
  }
}

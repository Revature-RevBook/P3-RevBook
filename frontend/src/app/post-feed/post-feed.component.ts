import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Post } from 'src/entity/post';
import { PostImageService } from 'src/services/post-image.service';
import { PostService } from 'src/services/post.service';

@Component({
  selector: 'app-post-feed',
  templateUrl: './post-feed.component.html',
  styleUrls: ['./post-feed.component.css']
})
export class PostFeedComponent implements OnInit {

  time = new Date();
  file:any;

  post:Partial<Post> = {
    postTitle: "",
    createdAt: this.time,
    postContent: "",
    userId: 0

  }

  constructor(private postService:PostService,
    private postImageService:PostImageService,
    private title:Title) { }

  ngOnInit(): void {
    this.title.setTitle('Feed Page');
  }

  submitPost() {
    this.post.userId = Number(sessionStorage.getItem('userId'));
    this.postService.addPost(this.post).subscribe(res => {
      if(res) {
        let file:any = document.getElementById('imageInput');
        if(file.files.length > 0) {
          this.file = file.files[0];
          this.postImageService.addImage(res.postId, this.file).subscribe();
          file.value = '';
        }
      }
    });
    this.post.postTitle = "";
    this.post.postContent = "";
  }

}

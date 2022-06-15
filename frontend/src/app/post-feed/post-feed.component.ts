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
  file: any;
  charsRemain: number = 255;

  post: Partial<Post> = {
    postTitle: "",
    createdAt: this.time,
    postContent: "",
    user: {}

  }

  constructor(private postService: PostService,
    private postImageService: PostImageService,
    private title: Title) { }

  ngOnInit(): void {
    this.title.setTitle('Feed Page');
  }

  changeCharsRemain(): void {
    this.charsRemain = 255- this.post.postContent!.length;
  }

  clearMsg() {
    setTimeout(() => {
      let postMsg: any = document.getElementById('postMsg');
      postMsg.innerHTML = '';
    }, 3000);
  }

  submitPost() {
    this.post.user!.userId = Number(sessionStorage.getItem('userId'));
    this.post.user!.username = String(sessionStorage.getItem('username'));
    this.postService.addPost(this.post).subscribe(res => {
      if (res) {
        let postMsg: any = document.getElementById('postMsg');
        postMsg.style = 'color: green;';
        postMsg.innerHTML = 'Post submitted.';
        let file: any = document.getElementById('imageInput');
        if (file.files.length > 0) {
          this.file = file.files[0];
          this.postImageService.addImage(res.postId, this.file).subscribe();
          file.value = '';
        }

        this.clearMsg();
      }
    });
    this.post.postTitle = "";
    this.post.postContent = "";
    this.changeCharsRemain();
  }

}
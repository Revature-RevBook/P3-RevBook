import { Component, OnInit } from '@angular/core';
import { PostService } from '../post.service';
import { Post } from '../post';

@Component({
  selector: 'app-post-feed',
  templateUrl: './post-feed.component.html',
  styleUrls: ['./post-feed.component.css']
})
export class PostFeedComponent implements OnInit {

  posts!: Post[];

  constructor(private postService: PostService) { }

  ngOnInit(): void {
    this.getAllBooks();
  }

  getAllbooks() {
    this.postService.getAllPosts().subscribe((posts:Post[]) =>{
      this.posts = posts;
    })
  }

}

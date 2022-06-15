import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Post } from 'src/entity/post';
import { PostService } from 'src/services/post.service';

@Component({
  selector: 'app-post-feed-table',
  templateUrl: './post-feed-table.component.html',
  styleUrls: ['./post-feed-table.component.css']
})
export class PostFeedTableComponent implements OnInit {
  
  posts:Post[] = [];

  constructor(private postService:PostService,
    private route:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    this.getAllPosts();
  }

  refreshPosts(): void {
    setTimeout(() => {
      this.getAllPosts();
    }, 3000);
  }

  getAllPosts() {

    this.postService.getAllPosts().subscribe((posts:Post[]) => {
      let index = 0;
      let placeholderPosts = [];

      // Step through result in reverse to put latest posts at top:
      for(let x = posts.length-1; x >= 0; x--) {
        placeholderPosts[index] = posts[x];
        index++;
      }
      this.posts = placeholderPosts;

      // this.posts = posts;
    })
  }
}
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Posts } from '../FakeData/Posts';

@Component({
  selector: 'app-post-details',
  templateUrl: './post-details.component.html',
  styleUrls: ['./post-details.component.css']
})
export class PostDetailsComponent implements OnInit {

  post : any;
  fakePosts!: any[];
  postid! : number;


  constructor(private router: Router) {
    const paths = this.router.url.split('/');
    this.postid = parseInt(paths[paths.length-1]);
    // console.log(this.postid);
    // console.log(Posts)
    Posts.forEach(post => {
      if (post.post_id === this.postid) {
        this.post = post;
      }
    })
    console.log(this.post);

  }

  ngOnInit(): void {
    this.fakePosts = Posts;
    console.log(this.fakePosts);
  }

}

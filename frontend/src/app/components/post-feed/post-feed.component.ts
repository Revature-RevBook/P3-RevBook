import { Component, OnInit } from '@angular/core';
import { Posts } from '../FakeData/Posts';

@Component({
  selector: 'app-create-post',
  templateUrl: './post-feed.component.html',
  styleUrls: ['./post-feed.component.css']
})
export class PostFeedComponent implements OnInit {
  FakePosts! : any[];
  contents : Array<string> = [];
  dates : Array<string> = [];
  index : number;



  constructor() {
    this.index = 0;
   
   }

  ngOnInit(): void {
    this.FakePosts = Posts
    for (let i = 0; i < this.FakePosts.length; i++) {
      this.dates.push(this.FakePosts[i].post_created_at.toDateString());
      this.contents.push(this.FakePosts[i].post_content.slice(0,50)); 
    }

  }

  removeTime(date : Date) {
    return date.toDateString();
  }

}

import { HttpClient } from '@angular/common/http';
import { Target } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Post } from '../post'
import { PostService } from '../services/post.service';

class ImageSnippet{
  constructor (public src: string, public file: File){}
}

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent implements OnInit {

  // Variable to store shortLink from api response
  shortLink: string = "";
  loading: boolean = false; // Flag variable
  file: File | any=null; // Variable to store file
  post!: Post;
 

  constructor(private postService: PostService) { }

  ngOnInit(): void {
    this.post = {
        post_title: "",
        post_content: ""
    }
  }

   // On file Select
   onChange(event:Event) {
    this.file = (event.target! as HTMLInputElement)!.files[0]!;
}

// OnClick of button Upload
onUpload() {
    this.loading = !this.loading;
    console.log(this.file);
    this.postService.upload(this.file).subscribe(
        (event: any) => {
            if (typeof (event) === 'object') {

                // Short link via api response
                this.shortLink = event.link;

                this.loading = false; // Flag variable 
            }
        }
    );
}

  createPost() {
    this.postService.createPost(this.post).subscribe((post: Post) => {
        this.post = post;
      })
  }
  


}

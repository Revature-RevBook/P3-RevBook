import { Component, Input, OnInit } from '@angular/core';
import { Comment } from 'src/entity/comment';
import { CommentService } from 'src/services/comment.service';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {
  @Input() postId:Number = 0;

  time = new Date();

  comment:Partial<Comment> = {
    createdAt: this.time,
    commentContent: '',
    commenter: {},
    postId: 0
  }

  constructor(private commentService:CommentService) { }

  ngOnInit(): void {
  }

  submitComment() {
    this.comment.commenter!.userId = Number(sessionStorage.getItem('userId'));
    this.comment.postId = this.postId;

    this.commentService.addComment(this.comment).subscribe(res => {
      if(res) {
        alert('Comment Submitted');
      }
    })
  }

}

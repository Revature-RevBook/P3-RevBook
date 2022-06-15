import { Component, Input, OnInit } from '@angular/core';
import { Comment } from 'src/entity/comment';
import { User } from 'src/entity/user';
import { CommentService } from 'src/services/comment.service';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {
  @Input() postId:Number = 0;

  time = new Date();
  charsRemain: number = 255;

  comment:Partial<Comment> = {
    createdAt: this.time,
    commentContent: '',
    commenter: {},
    postId: 0
  }

  constructor(private commentService:CommentService) { }

  ngOnInit(): void {
  }

  changeCharsRemain(): void {
    this.charsRemain = 255- this.comment.commentContent!.length;
  }

  clearMsg() {
    setTimeout(() => {
      let msg:any = document.getElementById('msg');
      msg.innerHTML = '';
    }, 3000);
  }

  submitComment() {
    let msg:any = document.getElementById('msg');
    msg.innerHTML = '';
    this.comment.commenter!.userId = Number(sessionStorage.getItem('userId'));
    this.comment.commenter!.username = String(sessionStorage.getItem('username'));
    this.comment.postId = this.postId;

    this.commentService.addComment(this.comment).subscribe(res => {
      if(res) {
        this.comment.commentContent = '';
        msg.style = 'color: green;';
        msg.innerHTML = 'Comment posted.';
        this.clearMsg();
        this.changeCharsRemain();
      }else {
        msg.style = 'color: red;';
        msg.innerHTML = 'Failed to send message';
      }
    })
  }

}
import { Component, Input, OnInit } from '@angular/core';
import { SubComment } from 'src/entity/sub-comment';
import { SubCommentService } from 'src/services/sub-comment.service';

@Component({
  selector: 'app-sub-comment',
  templateUrl: './sub-comment.component.html',
  styleUrls: ['./sub-comment.component.css']
})
export class SubCommentComponent implements OnInit {
  @Input() commentId: Number = 0;

  time = new Date();
  charsRemain: number = 255;

  subComment: Partial<SubComment> = {
    createdAt: this.time,
    subCommentContent: '',
    commenter: {},
    commentId: 0
  }

  constructor(private subCommentService:SubCommentService) { }

  ngOnInit(): void {
  }

  changeCharsRemain() {
    this.charsRemain = 255 - this.subComment.subCommentContent!.length;
  }

  clearMsg() {
    setTimeout(() => {
      let msg: any = document.getElementById('subCommentMsg');
      msg.innerHTML = '';
    }, 3000);
  }

  submitSubComment() {
    let msg: any = document.getElementById('subCommentMsg');
    msg.innerHTML = '';
    this.subComment.commenter!.userId = Number(sessionStorage.getItem('userId'));
    this.subComment.commenter!.username = String(sessionStorage.getItem('username'));
    this.subComment.commentId = this.commentId;

    this.subCommentService.addSubComment(this.subComment).subscribe(res => {
      if (res) {
        this.subComment.subCommentContent = '';
        msg.style = 'color: green;';
        msg.innerHTML = 'Sub-Comment posted.';
        this.clearMsg();
        this.changeCharsRemain();
      } else {
        msg.style = 'color: red;';
        msg.innerHTML = 'Failed to send message.';
      }
    })
  }

}
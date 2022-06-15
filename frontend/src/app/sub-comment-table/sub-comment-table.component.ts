import { Component, Input, OnInit } from '@angular/core';
import { SubComment } from 'src/entity/sub-comment';
import { User } from 'src/entity/user';
import { SubCommentService } from 'src/services/sub-comment.service';

@Component({
  selector: 'app-sub-comment-table',
  templateUrl: './sub-comment-table.component.html',
  styleUrls: ['./sub-comment-table.component.css']
})
export class SubCommentTableComponent implements OnInit {
  @Input() commentId: Number = 0;

  time = new Date();

  user:Partial<User> = {}

  subComment:SubComment = {
    subCommentId: 0,
    createdAt: this.time,
    updatedAt: this.time,
    commenter: this.user,
    commentId: 0
  }

  subComments:SubComment[] = [this.subComment];

  constructor(private subCommentService:SubCommentService) { }

  ngOnInit(): void {
    this.getAllSubComments();
  }

  refreshSubComments(): void {
    setTimeout(() => {
      this.getAllSubComments();
    }, 3000);
  }

  getAllSubComments() {
    this.subCommentService.getAllSubCommentsByCommentId(this.commentId).subscribe((subComments:SubComment[]) => {
      this.subComments = subComments;
    });
  }

}
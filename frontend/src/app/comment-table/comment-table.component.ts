import { Component, Input, OnInit } from '@angular/core';
import { Comment } from 'src/entity/comment';
import { CommentService } from 'src/services/comment.service';

@Component({
  selector: 'app-comment-table',
  templateUrl: './comment-table.component.html',
  styleUrls: ['./comment-table.component.css']
})
export class CommentTableComponent implements OnInit {
  @Input() postId:Number = 0;

  comments!:Comment[];

  constructor(private commentService:CommentService) { }

  ngOnInit(): void {
    this.getAllComments();
  }

  refreshComments(): void {
    setTimeout(() => {
      this.getAllComments();
    }, 3000);
  }

  getAllComments() {
    this.commentService.getAllCommentsByPostId(this.postId).subscribe((comments:Comment[]) => {
      this.comments = comments;
    });
  }

}
import { Component, Input, OnInit } from '@angular/core';
import { SubComment } from 'src/entity/sub-comment';
import { SubCommentService } from 'src/services/sub-comment.service';

@Component({
  selector: 'app-sub-comment-table',
  templateUrl: './sub-comment-table.component.html',
  styleUrls: ['./sub-comment-table.component.css']
})
export class SubCommentTableComponent implements OnInit {
  @Input() commentId: Number = 0;

  subComments!:SubComment[];

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

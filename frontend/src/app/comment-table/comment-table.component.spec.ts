import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule, By } from '@angular/platform-browser';
import { CommentTableComponent } from './comment-table.component';
import { RouterTestingModule } from '@angular/router/testing'
import { CommentService } from 'src/services/comment.service';
import { CommentServiceMock} from 'src/app/mocks/comment.service.mock'

describe('CommentTableComponent', () => {
  let component: CommentTableComponent;
  let fixture: ComponentFixture<CommentTableComponent>;

  let el: HTMLElement;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule, FormsModule],
      declarations: [ CommentTableComponent ],
      providers: [
        {provide: CommentService, useClass: CommentServiceMock}
      ]
    })
    .compileComponents();
  });


  beforeEach(waitForAsync(() => {
    fixture = TestBed.createComponent(CommentTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });


  it('should get comments from mock service', waitForAsync(() => {
    expect(component.comments).toBeTruthy();
    expect(component.comments[0].commentId).toEqual(1);
    expect(component.comments[0].commentContent).toContain('test comment');
    expect(component.comments[0].commenter.userId).toBeFalsy();
    expect(component.comments[0].postId).toEqual(1);
  }
  ))
});

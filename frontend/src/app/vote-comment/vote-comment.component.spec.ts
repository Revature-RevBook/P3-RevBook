import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule, By } from '@angular/platform-browser';
import { VoteCommentComponent } from './vote-comment.component';
import { RouterTestingModule } from '@angular/router/testing'
import { VoteCommentService } from 'src/services/vote-comment.service';
import { VoteCommentServiceMock } from '../mocks/vote-comment.service.mock';

describe('VoteCommentComponent', () => {
  let component: VoteCommentComponent;
  let fixture: ComponentFixture<VoteCommentComponent>;

  let el: HTMLElement;


  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule, FormsModule],
      declarations: [ VoteCommentComponent ],
      providers: [
        {provide: VoteCommentService, useClass: VoteCommentServiceMock}
      ]
    })
    .compileComponents();
  });


  beforeEach(waitForAsync(() => {
    fixture = TestBed.createComponent(VoteCommentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should get voteComment from mock service', waitForAsync(() => {
    expect(component.voteComments).toBeTruthy();
    expect(component.voteComments[0].voteId).toEqual(1);
    expect(component.voteComments[0].vote).toEqual(5);
    expect(component.voteComments[0].commentId).toEqual(1);
    expect(component.voteComments[0].voterId).toEqual(1);
  }
  ));

  it('should display vote count correctly', waitForAsync(() => {
    const fixture = TestBed.createComponent(VoteCommentComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('label')?.textContent).toContain('Votes: 5');
  }));

  it('should call incrementVoteComment method', waitForAsync(() => {
    fixture.detectChanges();
    spyOn(component, 'incrementVoteComment');

    el = fixture.debugElement.query(By.css('#up')).nativeElement;
    el.click();

    expect(component.incrementVoteComment).toHaveBeenCalledTimes(1);
  }));

  it('should call decrementVoteComment method', waitForAsync(() => {
    fixture.detectChanges();
    spyOn(component, 'decrementVoteComment');

    el = fixture.debugElement.query(By.css('#down')).nativeElement;
    el.click();

    expect(component.decrementVoteComment).toHaveBeenCalledTimes(1);
  }));
});

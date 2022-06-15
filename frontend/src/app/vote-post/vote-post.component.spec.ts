import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule, By } from '@angular/platform-browser';
import { VotePostComponent } from './vote-post.component';
import { RouterTestingModule } from '@angular/router/testing';
import { VotePostService } from 'src/services/vote-post.service';
import {VotePostServiceMock} from '../mocks/vote-post.service.mock';
import { NO_ERRORS_SCHEMA } from '@angular/core';

describe('VotePostComponent', () => {
  let component: VotePostComponent;
  let fixture: ComponentFixture<VotePostComponent>;

  let el: HTMLElement;


  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule, FormsModule],
      declarations: [ VotePostComponent ],
      providers: [
        {provide: VotePostService, useClass: VotePostServiceMock}
      ],
      schemas: [NO_ERRORS_SCHEMA]
    })
    .compileComponents();
  });


  beforeEach(waitForAsync(() => {
    fixture = TestBed.createComponent(VotePostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));


  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should get votePost from mock service', waitForAsync(() => {
    expect(component.votePosts).toBeTruthy();
    expect(component.votePosts[0].voteId).toEqual(1);
    expect(component.votePosts[0].vote).toEqual(5);
    expect(component.votePosts[0].postId).toEqual(1);
    expect(component.votePosts[0].voterId).toEqual(1);
  }
  ));

  it('should display vote count correctly', waitForAsync(() => {
    const fixture = TestBed.createComponent(VotePostComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('label')?.textContent).toContain('Votes: 5');
  }));

  it('should call incrementVotePost method', waitForAsync(() => {
    fixture.detectChanges();
    spyOn(component, 'incrementVotePost');

    el = fixture.debugElement.query(By.css('#up')).nativeElement;
    el.click();

    expect(component.incrementVotePost).toHaveBeenCalledTimes(1);
  }));

  it('should call decrementVotePost method', waitForAsync(() => {
    fixture.detectChanges();
    spyOn(component, 'decrementVotePost');

    el = fixture.debugElement.query(By.css('#down')).nativeElement;
    el.click();

    expect(component.decrementVotePost).toHaveBeenCalledTimes(1);
  }));

});

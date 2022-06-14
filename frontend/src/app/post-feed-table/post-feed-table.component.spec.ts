import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule, By } from '@angular/platform-browser';
import { PostFeedTableComponent } from './post-feed-table.component';
import { RouterTestingModule } from '@angular/router/testing'
import { PostService } from 'src/services/post.service';
import { PostServiceMock } from '../mocks/post.service.mock';

describe('PostFeedTableComponent', () => {
  let component: PostFeedTableComponent;
  let fixture: ComponentFixture<PostFeedTableComponent>;

  let el: HTMLElement;


  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule, FormsModule],
      declarations: [ PostFeedTableComponent ],
      providers: [
        {provide: PostService, useClass: PostServiceMock}
      ]
      })
    .compileComponents();
  });


  beforeEach(waitForAsync(() => {
    fixture = TestBed.createComponent(PostFeedTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should get post from mock service', waitForAsync(() => {
    expect(component.posts).toBeTruthy();
    expect(component.posts[0].postId).toEqual(1);
    expect(component.posts[0].postTitle).toContain('test title');
    expect(component.posts[0].postContent).toContain('test content');
    expect(component.posts[0].postImgId).toEqual(1);
    expect(component.posts[0].user.userId).toBeFalsy();
  }
  ));

  it('should display table content correctly', waitForAsync(() => {
    const fixture = TestBed.createComponent(PostFeedTableComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('tbody')?.textContent).toContain('PostId: 1');
    expect(compiled.querySelector('tbody')?.textContent).toContain('UserId: 1');
    expect(compiled.querySelector('tbody')?.textContent).toContain('Title: test title');
    expect(compiled.querySelector('tbody')?.textContent).toContain('Created At:');
    expect(compiled.querySelector('tbody')?.textContent).toContain('Updated At:');
    expect(compiled.querySelector('tbody')?.textContent).toContain('test content');
  }));

});

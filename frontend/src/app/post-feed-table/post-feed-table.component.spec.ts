import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostFeedTableComponent } from './post-feed-table.component';

describe('PostFeedTableComponent', () => {
  let component: PostFeedTableComponent;
  let fixture: ComponentFixture<PostFeedTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PostFeedTableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PostFeedTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

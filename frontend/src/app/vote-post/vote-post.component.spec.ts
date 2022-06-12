import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VotePostComponent } from './vote-post.component';

describe('VotePostComponent', () => {
  let component: VotePostComponent;
  let fixture: ComponentFixture<VotePostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VotePostComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VotePostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

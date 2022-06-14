import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubCommentComponent } from './sub-comment.component';

describe('SubCommentComponent', () => {
  let component: SubCommentComponent;
  let fixture: ComponentFixture<SubCommentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubCommentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SubCommentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

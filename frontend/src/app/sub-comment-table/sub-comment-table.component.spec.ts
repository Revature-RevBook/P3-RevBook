import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubCommentTableComponent } from './sub-comment-table.component';

describe('SubCommentTableComponent', () => {
  let component: SubCommentTableComponent;
  let fixture: ComponentFixture<SubCommentTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubCommentTableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SubCommentTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

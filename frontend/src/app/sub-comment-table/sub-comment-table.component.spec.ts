import { HttpClientModule } from '@angular/common/http';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';

import { SubCommentTableComponent } from './sub-comment-table.component';

describe('SubCommentTableComponent', () => {
  let component: SubCommentTableComponent;
  let fixture: ComponentFixture<SubCommentTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule, FormsModule],
      declarations: [ SubCommentTableComponent ],
      schemas: [NO_ERRORS_SCHEMA]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SubCommentTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  beforeEach(waitForAsync(() => {
    fixture = TestBed.createComponent(SubCommentTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

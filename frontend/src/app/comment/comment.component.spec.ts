import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule, By } from '@angular/platform-browser';
import { CommentComponent } from './comment.component';
import { RouterTestingModule } from '@angular/router/testing'

describe('CommentComponent', () => {
  let component: CommentComponent;
  let fixture: ComponentFixture<CommentComponent>;

  let el: HTMLElement;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule, FormsModule],
      declarations: [ CommentComponent ]
    })
    .compileComponents();
  });


  beforeEach(waitForAsync(() => {
    fixture = TestBed.createComponent(CommentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should initialize comment', waitForAsync(() => {
    expect(component.comment.commentContent).toEqual('');
    expect(component.comment.commenter?.userId).toBeFalsy();
    expect(component.comment.postId).toEqual(0);
  }));

  it('should display header correctly', waitForAsync(() => {
    const fixture = TestBed.createComponent(CommentComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h5')?.textContent).toContain('Comment:');
  }));

  it('should have an input element username', () => {
    const el = fixture.debugElement.query(By.css('.form-control'));
    expect(el).toBeTruthy();
    expect(el.nativeElement.getAttribute('type')).toEqual('text');
    expect(el.nativeElement.getAttribute('name')).toEqual('postComment');
  });

  it('should call submitComment method', waitForAsync(() => {
    const el = fixture.debugElement.query(By.css('form'));
    const fnc = spyOn(component, 'submitComment');

    el.triggerEventHandler('ngSubmit',null);
    
    expect(fnc).toHaveBeenCalled();
  }));
});

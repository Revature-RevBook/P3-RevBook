import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule, By } from '@angular/platform-browser';
import { PostFeedComponent } from './post-feed.component';
import { RouterTestingModule } from '@angular/router/testing'
import { NO_ERRORS_SCHEMA } from '@angular/core';

describe('PostFeedComponent', () => {
  let component: PostFeedComponent;
  let fixture: ComponentFixture<PostFeedComponent>;

  let el: HTMLElement;


  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule, FormsModule],
      declarations: [ PostFeedComponent ],
      schemas: [NO_ERRORS_SCHEMA]
    })
    .compileComponents();
  });


  beforeEach(waitForAsync(() => {
    fixture = TestBed.createComponent(PostFeedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display header correctly', waitForAsync(() => {
    const fixture = TestBed.createComponent(PostFeedComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h1')?.textContent).toContain('Create Post:');
  }));

  it('should have an input element Title', () => {
    const el = fixture.debugElement.query(By.css('#inputStyle'));
    expect(el).toBeTruthy();
    expect(el.nativeElement.getAttribute('type')).toEqual('text');
    expect(el.nativeElement.getAttribute('name')).toEqual('postTitle');
  });

  it('should have an input element Content', () => {
    const el = fixture.debugElement.query(By.css('#postContent'));
    expect(el).toBeTruthy();
    expect(el.nativeElement.getAttribute('type')).toEqual('text');
    expect(el.nativeElement.getAttribute('name')).toEqual('postContent');
  });

  it('should have an input element Image', () => {
    const el = fixture.debugElement.query(By.css('#imageInput'));
    expect(el).toBeTruthy();
    expect(el.nativeElement.getAttribute('type')).toEqual('file');
  });

  it('should call submitPost method', waitForAsync(() => {
    const el = fixture.debugElement.query(By.css('form'));
    const fnc = spyOn(component, 'submitPost');

    el.triggerEventHandler('ngSubmit',null);
    
    expect(fnc).toHaveBeenCalled();
  }));

  it('should update the post property', waitForAsync(() => {
    const hostElement = fixture.nativeElement;

    const titleInput: HTMLInputElement = hostElement.querySelector("#inputStyle");
    const contentInput: HTMLInputElement = hostElement.querySelector("#postContent");
    const imageInput: HTMLInputElement = hostElement.querySelector("#imageInput");
    fixture.detectChanges();

    titleInput.value = "test title";
    contentInput.value = "test content";
    imageInput.value ='';

    titleInput.dispatchEvent(new Event('input'));
    contentInput.dispatchEvent(new Event('input'));
    imageInput.dispatchEvent(new Event('input'));

    expect(component.post.postTitle).toBe('test title');
    expect(component.post.postContent).toBe('test content');
    expect(component.file).toBe(undefined);
  }));
});

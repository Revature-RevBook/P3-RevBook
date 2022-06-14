import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule, By } from '@angular/platform-browser';

import { HomeComponent } from './home.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { DebugElement } from '@angular/core';
import { RouterTestingModule } from '@angular/router/testing'

describe('HomeComponent', () => {
  let component: HomeComponent;
  let fixture: ComponentFixture<HomeComponent>;

  let el: HTMLElement;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule],
      declarations: [ HomeComponent ]
    })
    .compileComponents();

  });

  beforeEach(waitForAsync(() => {
    fixture = TestBed.createComponent(HomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));


  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display header correctly', waitForAsync(() => {
    const fixture = TestBed.createComponent(HomeComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h1')?.textContent).toContain('Welcome to RevBook!');
  }));

  it('should display body correctly', waitForAsync(() => {
    const fixture = TestBed.createComponent(HomeComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('body')?.textContent).toContain('This website allows Revature employees to interact with one another.');
    expect(compiled.querySelector('body')?.textContent).toContain('Users have a variety of options available:');
    expect(compiled.querySelector('body')?.textContent).toContain('Please join the online Revature community today and start connecting!');
  }));

  it('should display list correctly', waitForAsync(() => {
    const fixture = TestBed.createComponent(HomeComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('ul')?.textContent).toContain('View Posts');
    expect(compiled.querySelector('ul')?.textContent).toContain('Create Posts');
    expect(compiled.querySelector('ul')?.textContent).toContain('Add Images to their Posts');
    expect(compiled.querySelector('ul')?.textContent).toContain('Comment on Posts');
    expect(compiled.querySelector('ul')?.textContent).toContain('Like/Dislike Posts/Comments');
    expect(compiled.querySelector('ul')?.textContent).toContain('Message other Employees');
    expect(compiled.querySelector('ul')?.textContent).toContain('... More coming');
  }));

  it('should call login method', waitForAsync(() => {
    fixture.detectChanges();
    spyOn(component, 'login');
    el = fixture.debugElement.query(By.css('#login')).nativeElement;
    el.click();
    expect(component.login).toHaveBeenCalledTimes(1);
  }))

  it('should call signup method', waitForAsync(() => {
    fixture.detectChanges();
    spyOn(component, 'signup');
    el = fixture.debugElement.query(By.css('#signup')).nativeElement;
    el.click();
    expect(component.signup).toHaveBeenCalledTimes(1);
  }))
});

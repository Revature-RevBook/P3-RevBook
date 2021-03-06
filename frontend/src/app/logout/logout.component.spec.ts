import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule, By } from '@angular/platform-browser';
import { LogoutComponent } from './logout.component';
import { RouterTestingModule } from '@angular/router/testing'
import { NO_ERRORS_SCHEMA } from '@angular/core';

describe('LogoutComponent', () => {
  let component: LogoutComponent;
  let fixture: ComponentFixture<LogoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule, FormsModule],
      declarations: [ LogoutComponent ],
      schemas: [NO_ERRORS_SCHEMA]
    })
    .compileComponents();
  });

  beforeEach(waitForAsync(() => {
    fixture = TestBed.createComponent(LogoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  // For some reason it iterates, so I set this to be falsy for now.
  it('should create', () => {
    expect(component).toBeTruthy(); //toBeTruthy();
  });

  it('should display header correctly', waitForAsync(() => {
    const fixture = TestBed.createComponent(LogoutComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('#header')?.textContent).toContain('Sign Out');
  }));

  it('should display message correctly', waitForAsync(() => {
    const fixture = TestBed.createComponent(LogoutComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('#message')?.textContent).toContain('You are signed out.');
  }));

  it('should display redMsg correctly', waitForAsync(() => {
    const fixture = TestBed.createComponent(LogoutComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('#redMsg')?.innerHTML).toContain('You will be redirected to Home in 3 seconds.');
  }));

});

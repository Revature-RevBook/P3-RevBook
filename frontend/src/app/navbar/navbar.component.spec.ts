import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule, By } from '@angular/platform-browser';
import { NavbarComponent } from './navbar.component';
import { RouterTestingModule } from '@angular/router/testing'
import { NO_ERRORS_SCHEMA } from '@angular/core';

describe('NavbarComponent', () => {
  let component: NavbarComponent;
  let fixture: ComponentFixture<NavbarComponent>;

  let el: HTMLElement;


  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule, FormsModule],
      declarations: [ NavbarComponent ],
      schemas: [NO_ERRORS_SCHEMA]
    })
    .compileComponents();
  });


  beforeEach(waitForAsync(() => {
    fixture = TestBed.createComponent(NavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display list correctly', waitForAsync(() => {
    const fixture = TestBed.createComponent(NavbarComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('ul')?.textContent).toContain('Home');
    expect(compiled.querySelector('ul')?.textContent).toContain('Account');
    expect(compiled.querySelector('ul')?.textContent).toContain('Feed');
    expect(compiled.querySelector('ul')?.textContent).toContain('Messages');
  }));

  it('should map to path correctly', waitForAsync(() => {
    let hrefHome = fixture.debugElement.query(By.css('#home')).nativeElement.getAttribute('href');
    let hrefAccount = fixture.debugElement.query(By.css('#account')).nativeElement.getAttribute('href');
    let hrefFeed = fixture.debugElement.query(By.css('#feed')).nativeElement.getAttribute('href');
    let hrefMessages = fixture.debugElement.query(By.css('#messages')).nativeElement.getAttribute('href');
    expect(hrefHome).toContain('/');
    expect(hrefAccount).toContain('/account');
    expect(hrefFeed).toContain('/feed');
    expect(hrefMessages).toContain('/messages');
  }));

  // it('should call logout method', waitForAsync(() => {
  //   fixture.detectChanges();
  //   spyOn(component, 'logout');

  //   el = fixture.debugElement.query(By.css('button')).nativeElement;
  //   el.click();

  //   expect(component.logout).toHaveBeenCalledTimes(1);
  // }));
});

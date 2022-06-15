import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule, By } from '@angular/platform-browser';
import { LoginComponent } from './login.component';
import { RouterTestingModule } from '@angular/router/testing'
import { NO_ERRORS_SCHEMA } from '@angular/core';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  let el: HTMLElement;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule, FormsModule],
      declarations: [ LoginComponent ],
      schemas: [NO_ERRORS_SCHEMA]
    })
    .compileComponents();
  });


  beforeEach(waitForAsync(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  //testing out default book values during ngOnInit
  it('should initialize user', waitForAsync(() => {
    expect(component.user.userId).toEqual(0);
    expect(component.user.username).toEqual('');
    expect(component.user.password).toEqual('');
    expect(component.user.email).toEqual('');
    expect(component.user.profileImgLink).toEqual('');
  }))


  it('should display header correctly', waitForAsync(() => {
    const fixture = TestBed.createComponent(LoginComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('#tab-login')?.textContent).toContain('Login');
  }));

  //username
  it('should have an input element username', () => {
    const el = fixture.debugElement.query(By.css('#username'));
    expect(el).toBeTruthy();
    expect(el.nativeElement.getAttribute('type')).toEqual('username');
    expect(el.nativeElement.getAttribute('name')).toEqual('username');
  })

  //password
  it('should have an input element password', () => {
    const el = fixture.debugElement.query(By.css('#password'));
    expect(el).toBeTruthy();
    expect(el.nativeElement.getAttribute('type')).toEqual('password');
    expect(el.nativeElement.getAttribute('name')).toEqual('password');
  })


  //this test is to check submitting calls login function.
  it('should call login method', waitForAsync(() => {
    const el = fixture.debugElement.query(By.css('form'));
    const fnc = spyOn(component, 'login');

    el.triggerEventHandler('ngSubmit',null);
    
    expect(fnc).toHaveBeenCalled();
  }));


  it('should update the user property - inside the component', waitForAsync(() => {
    const hostElement = fixture.nativeElement;

    const usernameInput: HTMLInputElement = hostElement.querySelector("#username");
    const passwordInput: HTMLInputElement = hostElement.querySelector("#password");
    fixture.detectChanges();

    usernameInput.value = "test";
    passwordInput.value = "passTest";

    usernameInput.dispatchEvent(new Event('input'));
    passwordInput.dispatchEvent(new Event('input'));

    expect(component.model.username).toBe('test');
    expect(component.model.password).toBe('passTest');
  }));
});

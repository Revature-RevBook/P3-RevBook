import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule, By } from '@angular/platform-browser';
import { AccountComponent } from './account.component';
import { RouterTestingModule } from '@angular/router/testing'
import { NO_ERRORS_SCHEMA } from '@angular/core';

describe('AccountComponent', () => {
  let component: AccountComponent;
  let fixture: ComponentFixture<AccountComponent>;

  let el: HTMLElement;


  beforeEach(async () => {
    //defining session info
    sessionStorage.setItem('username', 'test');
    sessionStorage.setItem('email', 'testemail');
    sessionStorage.setItem('profileImgLink', 'testurl');
    
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule, FormsModule],
      declarations: [AccountComponent],
      schemas: [NO_ERRORS_SCHEMA]
    })
      .compileComponents();
  });


  beforeEach(waitForAsync(() => {
    fixture = TestBed.createComponent(AccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();



  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should initialize user', waitForAsync(() => {
    expect(component.user.username).toEqual('test');
    expect(component.user.email).toEqual('testemail');
    expect(component.user.profileImgLink).toEqual('testurl');
  }))


  it('should display header correctly', waitForAsync(() => {
    const fixture = TestBed.createComponent(AccountComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h1')?.textContent).toContain('Account Details');
  }));

  it('should display header2 correctly', waitForAsync(() => {
    const fixture = TestBed.createComponent(AccountComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h2')?.textContent).toContain('Delete Account');
  }));

  it('should have an input element username', () => {
    const el = fixture.debugElement.query(By.css('#inputUsername'));
    expect(el).toBeTruthy();
    expect(el.nativeElement.getAttribute('type')).toEqual('text');
    expect(el.nativeElement.getAttribute('name')).toEqual('username');
  });

  it('should have an input element password', () => {
    const el = fixture.debugElement.query(By.css('#inputPassword'));
    expect(el).toBeTruthy();
    expect(el.nativeElement.getAttribute('type')).toEqual('password');
    expect(el.nativeElement.getAttribute('name')).toEqual('password');
  });

  it('should have an input element email', () => {
    const el = fixture.debugElement.query(By.css('#inputEmail'));
    expect(el).toBeTruthy();
    expect(el.nativeElement.getAttribute('type')).toEqual('text');
    expect(el.nativeElement.getAttribute('name')).toEqual('email');
  });

  it('should call updateAccount method', waitForAsync(() => {
    const el = fixture.debugElement.query(By.css('form'));
    const fnc = spyOn(component, 'updateAccount');

    el.triggerEventHandler('ngSubmit', null);

    expect(fnc).toHaveBeenCalled();
  }));

  it('should update the user property - inside the component', waitForAsync(() => {
    const hostElement = fixture.nativeElement;

    const usernameInput: HTMLInputElement = hostElement.querySelector("#inputUsername");
    const passwordInput: HTMLInputElement = hostElement.querySelector("#inputPassword");
    const emailInput: HTMLInputElement = hostElement.querySelector("#inputEmail");
    fixture.detectChanges();

    usernameInput.value = "test";
    passwordInput.value = "passTest";
    emailInput.value = 'test@test.com';

    usernameInput.dispatchEvent(new Event('input'));
    passwordInput.dispatchEvent(new Event('input'));
    emailInput.dispatchEvent(new Event('input'));

    expect(component.user.username).toBe('test');
    expect(component.user.password).toBe('passTest');
    expect(component.user.email).toBe('test@test.com');
  }));

  it('should call deleteAccount method', waitForAsync(() => {
    const el = fixture.debugElement.query(By.css('#deleteAccount'));
    const fnc = spyOn(component, 'deleteAccount');

    el.triggerEventHandler('ngSubmit', null);

    expect(fnc).toHaveBeenCalled();
  }));

  it('should update the input property', waitForAsync(() => {
    const hostElement = fixture.nativeElement;

    const deleteAccount: HTMLInputElement = hostElement.querySelector("#deleteMyAccount");

    fixture.detectChanges();

    deleteAccount.value = "test";

    deleteAccount.dispatchEvent(new Event('input'));

    expect(component.modelDeleteAccount.deleteText).toBe('test');

  }));
});

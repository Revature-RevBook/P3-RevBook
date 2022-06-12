import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule, By } from '@angular/platform-browser';
import { RegisterComponent } from './register.component';

describe('RegisterComponent', () => {
  let component: RegisterComponent;
  let fixture: ComponentFixture<RegisterComponent>;

  let el: HTMLElement;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, FormsModule, ReactiveFormsModule],
      declarations: [ RegisterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  //testing out default book values during ngOnInit
  it('should initialize user', waitForAsync(() => {
    expect(component.user.user_name).toEqual('');
  }))

  //this test is to check clicking the button calls register function one time.
  it('should call register method', waitForAsync(() => {
    fixture.detectChanges();
    spyOn(component, 'register');
    el = fixture.debugElement.query(By.css('button')).nativeElement;
    el.click();
    expect(component.register).toHaveBeenCalledTimes(1);
  }))

  it('should update the user property - inside the component', waitForAsync(() => {
    const hostElement = fixture.nativeElement;

    const usernameInput: HTMLInputElement = hostElement.querySelector("#user_name");
    const emailInput: HTMLInputElement = hostElement.querySelector("#email");
    const passwordInput: HTMLInputElement = hostElement.querySelector("#password");
    fixture.detectChanges();

    usernameInput.value = "test";
    emailInput.value = "test@test.com";
    passwordInput.value = "passTest";

    usernameInput.dispatchEvent(new Event('input'));
    emailInput.dispatchEvent(new Event('input'));
    passwordInput.dispatchEvent(new Event('input'));

    expect(component.user.user_name).toBe('test');
    expect(component.user.user_email).toBe('test@test.com');
    expect(component.user.password).toBe('passTest');
  }))
});

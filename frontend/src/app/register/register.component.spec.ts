import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule, By } from '@angular/platform-browser';
import { RegisterComponent } from './register.component';
import { RouterTestingModule } from '@angular/router/testing'

describe('RegisterComponent', () => {
  let component: RegisterComponent;
  let fixture: ComponentFixture<RegisterComponent>;

  let el: HTMLElement;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule, FormsModule],
      declarations: [ RegisterComponent ]
    })
    .compileComponents();
  });


  beforeEach(waitForAsync(() => {
    fixture = TestBed.createComponent(RegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));


  it('should create', () => {
    expect(component).toBeTruthy();
  });

    //testing out default book values during ngOnInit
    it('should initialize user', waitForAsync(() => {
      expect(component.user.username).toEqual('');
      expect(component.user.password).toEqual('');
      expect(component.user.email).toEqual('');
    }))
  

    it('should display header correctly', waitForAsync(() => {
      const fixture = TestBed.createComponent(RegisterComponent);
      fixture.detectChanges();
      const compiled = fixture.nativeElement as HTMLElement;
      expect(compiled.querySelector('h1')?.textContent).toContain('Please provide account details to sign up:');
    }));

    //username
    it('should have an input element username', () => {
      const el = fixture.debugElement.query(By.css('#username'));
      expect(el).toBeTruthy();
      expect(el.nativeElement.getAttribute('type')).toEqual('text');
      expect(el.nativeElement.getAttribute('name')).toEqual('username');
    })

    //password
    it('should have an input element password', () => {
      const el = fixture.debugElement.query(By.css('#password'));
      expect(el).toBeTruthy();
      expect(el.nativeElement.getAttribute('type')).toEqual('password');
      expect(el.nativeElement.getAttribute('name')).toEqual('password');
    })

    //email
    it('should have an input element email', () => {
      const el = fixture.debugElement.query(By.css('#email'));
      expect(el).toBeTruthy();
      expect(el.nativeElement.getAttribute('type')).toEqual('email');
      expect(el.nativeElement.getAttribute('name')).toEqual('email');
    })




    //this test is to check submitting calls register function.
    it('should call register method', waitForAsync(() => {
      const el = fixture.debugElement.query(By.css('form'));
      const fnc = spyOn(component, 'register');

      el.triggerEventHandler('ngSubmit',null);
      
      expect(fnc).toHaveBeenCalled();
    }))

  
    it('should update the user property - inside the component', waitForAsync(() => {
      const hostElement = fixture.nativeElement;
  
      const usernameInput: HTMLInputElement = hostElement.querySelector("#username");
      const emailInput: HTMLInputElement = hostElement.querySelector("#email");
      const passwordInput: HTMLInputElement = hostElement.querySelector("#password");
      fixture.detectChanges();
  
      usernameInput.value = "test";
      emailInput.value = "test@test.com";
      passwordInput.value = "passTest";
  
      usernameInput.dispatchEvent(new Event('input'));
      emailInput.dispatchEvent(new Event('input'));
      passwordInput.dispatchEvent(new Event('input'));
  
      expect(component.user.username).toBe('test');
      expect(component.user.email).toBe('test@test.com');
      expect(component.user.password).toBe('passTest');
    }))
});

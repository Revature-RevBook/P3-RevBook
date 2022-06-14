import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule, By } from '@angular/platform-browser';
import { MessagesComponent } from './messages.component';
import { RouterTestingModule } from '@angular/router/testing'

describe('MessagesComponent', () => {
  let component: MessagesComponent;
  let fixture: ComponentFixture<MessagesComponent>;

  let el: HTMLElement;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule, FormsModule],
      declarations: [ MessagesComponent ]
    })
    .compileComponents();
  });

  beforeEach(waitForAsync(() => {
    fixture = TestBed.createComponent(MessagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should initialize message', waitForAsync(() => {
    expect(component.message.messageContent).toEqual('');
    expect(component.message.sender?.userId).toEqual(0);
    expect(component.message.recipient?.userId).toEqual(0);
  }));

  it('should display header correctly', waitForAsync(() => {
    const fixture = TestBed.createComponent(MessagesComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h1')?.textContent).toContain('Send Message:');
  }));

  it('should have an input element message content', () => {
    const el = fixture.debugElement.query(By.css('#message'));
    expect(el).toBeTruthy();
    expect(el.nativeElement.getAttribute('type')).toEqual('text');
    expect(el.nativeElement.getAttribute('name')).toEqual('message');
  });

  it('should have an input element recipient', () => {
    const el = fixture.debugElement.query(By.css('#recipient'));
    expect(el).toBeTruthy();
    expect(el.nativeElement.getAttribute('type')).toEqual('text');
    expect(el.nativeElement.getAttribute('name')).toEqual('recipient');
  });

  it('should call sendMessage method', waitForAsync(() => {
    const el = fixture.debugElement.query(By.css('form'));
    const fnc = spyOn(component, 'sendMessage');

    el.triggerEventHandler('ngSubmit',null);
    
    expect(fnc).toHaveBeenCalled();
  }));
});

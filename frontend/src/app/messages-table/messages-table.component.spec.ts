import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule, By } from '@angular/platform-browser';
import { MessagesTableComponent } from './messages-table.component';
import { RouterTestingModule } from '@angular/router/testing'
import { MessageService } from 'src/services/message.service';
import { MessageServiceMock } from '../mocks/message.service.mock';

describe('MessageTableComponent', () => {
  let component: MessagesTableComponent;
  let fixture: ComponentFixture<MessagesTableComponent>;

  let el: HTMLElement;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule, FormsModule],
      declarations: [ MessagesTableComponent ],
      providers: [
        {provide: MessageService, useClass: MessageServiceMock}
      ]
    })
    .compileComponents();
  });


  beforeEach(waitForAsync(() => {
    fixture = TestBed.createComponent(MessagesTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should get message from mock service', waitForAsync(() => {
    expect(component.messages).toBeTruthy();
    expect(component.messages[0].messageContent).toContain('test message');
    expect(component.messages[0].sender.userId).toEqual(1);
    expect(component.messages[0].messageId).toEqual(1);
  }
  ));


  it('should display table header correctly', waitForAsync(() => {
    const fixture = TestBed.createComponent(MessagesTableComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('thead')?.textContent).toContain('Id');
    expect(compiled.querySelector('thead')?.textContent).toContain('Sender');
    expect(compiled.querySelector('thead')?.textContent).toContain('Message');
  }));


  it('should display header correctly', waitForAsync(() => {
    const fixture = TestBed.createComponent(MessagesTableComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h5')?.textContent).toContain('Respond to Message');
  }));

  it('should call selectMessage method', waitForAsync(() => {
    fixture.detectChanges();
    spyOn(component, 'selectMessage');

    el = fixture.debugElement.query(By.css('button')).nativeElement;
    el.click();

    expect(component.selectMessage).toHaveBeenCalledTimes(1);
  }));

  it('should update the message property', waitForAsync(() => {
    const hostElement = fixture.nativeElement;

    const responseTextArea: HTMLTextAreaElement = hostElement.querySelector("#response");
    fixture.detectChanges();

    responseTextArea.value = "test response";

    responseTextArea.dispatchEvent(new Event('input'));

    expect(component.message.messageContent).toBe('test response');
  }));

  it('should call sendMessage method', waitForAsync(() => {
    const el = fixture.debugElement.query(By.css('form'));
    const fnc = spyOn(component, 'sendMessage');

    el.triggerEventHandler('ngSubmit',null);
    
    expect(fnc).toHaveBeenCalled();
  }));
});

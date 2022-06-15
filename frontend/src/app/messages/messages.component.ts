import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { timeout } from 'rxjs';
import { Message } from 'src/entity/message';
import { MessageService } from 'src/services/message.service';
import { UserService } from 'src/services/user.service';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  time = new Date();
  charsRemain: number = 255;
  userId!:Number;

  message:Partial<Message> = {
    createdAt: this.time,
    messageContent: "",
    sender: {},
    recipient: {}
  }

  constructor(private userService:UserService,
    private messageService:MessageService,
    private route:ActivatedRoute,
    private router:Router,
    private title:Title) { }

  ngOnInit(): void {
    this.title.setTitle('Messages');
    this.userId = Number(sessionStorage.getItem('userId'));
  }

  changeCharsRemain(): void {
    this.charsRemain = 255- this.message.messageContent!.length;
  }

  clearMsg() {
    setTimeout(() => {
      let msg:any = document.getElementById('messageMsg');
      msg.innerHTML = '';
    }, 3000);
  }

  sendMessage() {
    this.message.sender!.userId = Number(sessionStorage.getItem('userId'));
    this.message.sender!.username = String(sessionStorage.getItem('username'));
    this.messageService.addMessage(this.message).subscribe(res => {
      if(res == true) {
        this.message.messageContent = "";
        this.message.recipient = {};
        let messageMsg:any = document.getElementById('messageMsg');
        messageMsg!.style = "color: green;";
        messageMsg!.innerHTML = "Message Sent";
        this.clearMsg();
        this.changeCharsRemain();
      }else if (res == false) {
        let messageMsg:any = document.getElementById('messageMsg');
        messageMsg!.style = "color: red;";
        messageMsg!.innerHTML = "User does not exist";
        this.clearMsg();
      }else {
        let messageMsg:any = document.getElementById('messageMsg');
        messageMsg!.style = "color: red;";
        messageMsg!.innerHTML = "Error sending Message. Please try again.";
        this.clearMsg();
      }
    });
  }

}
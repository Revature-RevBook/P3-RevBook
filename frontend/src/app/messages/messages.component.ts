import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { Message } from 'src/entity/message';
import { MessageService } from 'src/services/message.service';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  time = new Date();

  message:Partial<Message> = {
    createdAt: this.time,
    messageContent: "",
    sender: {},
    recipient: {}
  }

  constructor(private messageService:MessageService,
    private route:ActivatedRoute,
    private router:Router,
    private title:Title) { }

  ngOnInit(): void {
    this.title.setTitle('Messages');
  }

  sendMessage() {
    this.message.sender!.userId = Number(sessionStorage.getItem('userId'));
    this.messageService.addMessage(this.message).subscribe(res => {
      if(res) {
        console.log(res);
        alert('Message sent.');
      }
    });
  }

}
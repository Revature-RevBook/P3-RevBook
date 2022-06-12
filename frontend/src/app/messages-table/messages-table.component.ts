import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Message } from 'src/entity/message';
import { MessageService } from 'src/services/message.service';

@Component({
  selector: 'app-messages-table',
  templateUrl: './messages-table.component.html',
  styleUrls: ['./messages-table.component.css']
})
export class MessagesTableComponent implements OnInit {

  time = new Date();

  message:Partial<Message> = {
    createdAt: this.time,
    messageContent: "",
    senderId: 0,
    recipientId: 0
  }

  messages!:Message[];

  constructor(private messageService:MessageService,
    private route:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    this.getMessagesByRecipient(Number(sessionStorage.getItem('userId')));
  }

  getMessagesByRecipient(id:Number) {
    this.messageService.getAllMessagesByRecipientId(id).subscribe((messages:Message[]) => {
      this.messages = messages;
    })

  }

  selectMessage(id:Number, senderId:Number) {
    sessionStorage.setItem('messageId', String(id));
    this.message.senderId = Number(sessionStorage.getItem('userId'));
    this.message.recipientId = senderId;
    let ansTag:any = document.getElementById('respondToMsg');
    ansTag.style.display="block";
    window.location.href="/messages#respond_section";

    let respElement:any = document.getElementById('response');
    respElement.value = "";
    this.message.messageContent = "";

    let headerElement:any = document.getElementById('responseHeader');
    headerElement.innerHTML += id;
  }

  sendMessage() {
    this.messageService.addMessage(this.message).subscribe(res => {
      if(res) {
        console.log(res);
        let respElement:any = document.getElementById('response');
        console.log(respElement);
        respElement.value = "";
        this.message.messageContent = "";
      }
    });
    this.messageService.deleteMessage(Number(sessionStorage.getItem('messageId'))).subscribe(res => {
      if(res) {
        console.log(res);
      }
    });

    window.setTimeout(function() {
      location.reload();
    }, 2000);
  }

}

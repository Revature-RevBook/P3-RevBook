import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Message } from 'src/entity/message';
import { User } from 'src/entity/user';
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
    sender: {},
    recipient: {}
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

  selectMessage(id:Number, user:Partial<User>) {
    sessionStorage.setItem('messageId', String(id));
    this.message.sender!.userId = Number(sessionStorage.getItem('userId'));
    this.message.recipient!.userId = user.userId;
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

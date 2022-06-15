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
  charsRemain: number = 255;

  message: Partial<Message> = {
    createdAt: this.time,
    messageContent: "",
    sender: {},
    recipient: {}
  }

  messages!: Message[];

  constructor(private messageService: MessageService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.getMessagesByRecipient(Number(sessionStorage.getItem('userId')));
  }

  changeCharsRemain(): void {
    this.charsRemain = 255- this.message.messageContent!.length;
  }

  clearMsg() {
    setTimeout(() => {
      let answerMsg: any = document.getElementById('answerMsg');
      answerMsg.innerHTML = "";
    }, 3000);
  }

  delayedGetMessagesByRecipient(id: Number) {
    setTimeout(() => {
      this.getMessagesByRecipient(id);
    }, 3000)
  }

  getMessagesByRecipient(id: Number) {
    this.messageService.getAllMessagesByRecipientId(id).subscribe((messages: Message[]) => {
      this.messages = messages;
    })
  }

  selectMessage(id: number, messageId: Number, sender: Partial<User>) {
    sessionStorage.setItem('messageId', String(messageId));
    this.message.sender!.userId = Number(sessionStorage.getItem('userId'));
    this.message.sender!.username = String(sessionStorage.getItem('username'));
    this.message.recipient = sender;
    let ansTag: any = document.getElementById('respondToMsg');
    ansTag.style.display = "block";
    window.location.href = "/messages#respond_section";

    let respElement: any = document.getElementById('response');
    respElement.value = "";
    this.message.messageContent = "";

    let headerElement: any = document.getElementById('responseHeader');
    headerElement.innerHTML = "Respond to Message " + (id + 1);
  }

  closeMessage() {
    // Close response box and set focus to the top of the page:
    this.getMessagesByRecipient(Number(sessionStorage.getItem('userId')));
    let ansTag: any = document.getElementById('respondToMsg');
    ansTag.style.display = "none";
    window.location.href = "/messages#top_section";
  }

  sendMessage() {
    // Check if textbox is empty:
    let respElement: any = document.getElementById('response');
    let answerMsg: any = document.getElementById('answerMsg');
    if (respElement.value == "") {
      answerMsg.style = "color: red;"
      answerMsg.innerHTML = "Please enter a message";
      this.clearMsg();
      return;
    }

    // Anything in the box, send away:
    this.messageService.addMessage(this.message).subscribe(res => {
      if (res) {
        respElement.value = "";
        this.message.messageContent = "";
        answerMsg.style = "color: green;"
        answerMsg.innerHTML = "Message Sent";
        this.clearMsg();
      }
    });
    this.messageService.deleteMessage(Number(sessionStorage.getItem('messageId'))).subscribe(res => {
      if (res) {
        console.log(res);
      }
    });

    // Retrieve updated list of messages, and set focus to the top of the page:
    setTimeout(() => {
      this.getMessagesByRecipient(Number(sessionStorage.getItem('userId')));
      let ansTag: any = document.getElementById('respondToMsg');
      ansTag.style.display = "none";
      window.location.href = "/messages#top_section";
    }, 2000);
  }

  deleteMessage(id: Number, messageId: Number) {
    // Display deleting message:
    let deleteMsgElement: any = document.getElementById('deleteMsg' + id);
    deleteMsgElement.style = "color: blue;";
    deleteMsgElement.innerHTML = "Deleting..."

    // Disable selected button to prevent repeated inputs/clicking:
    let deleteBtn: any = document.getElementById('deleteBtn' + id);
    deleteBtn.disabled = true;

    // Call MessageService to delete selected message:
    this.messageService.deleteMessage(messageId).subscribe(res => {
      if (res) {
        console.log(res);
      }
    });

    // Retrieve updated list of messages:
    setTimeout(() => {
      this.getMessagesByRecipient(Number(sessionStorage.getItem('userId')));
    }, 1000);
  }

}
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Message } from 'src/entity/message';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private http:HttpClient) { }

  addMessage(message:Partial<Message>) {
    return this.http.post<any>('http://localhost:8080/messages', message);
  }

  getAllMessages() {
    return this.http.get<Message[]>('http://localhost:8080/messages');
  }

  getMessageById(messageId:Number) {
    return this.http.get<Message>(`http://localhost:8080/messages/${messageId}`);
  }

  getAllMessagesByRecipientId(recipientId:Number) {
    return this.http.get<Message[]>(`http://localhost:8080/messages/recipient/${recipientId}`)
  }

  updateMessage(message:Message) {
    return this.http.put<Message>(`http://localhost:8080/messages/${message.messageId}`, message);
  }

  deleteMessage(messageId:Number) {
    return this.http.delete(`http://localhost:8080/messages/${messageId}`);
  }
}

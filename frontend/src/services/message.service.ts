import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Message } from 'src/entity/message';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private http:HttpClient) { }

  addMessage(message:Partial<Message>) {
<<<<<<< HEAD
    return this.http.post<any>('http://localhost:8080/messages', message);
=======
    return this.http.post<Message>('http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/messages', message);
>>>>>>> 4dd5f1dade7704efeb81f85f0e78ec6d1f33e368
  }

  getAllMessages() {
    return this.http.get<Message[]>('http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/messages');
  }

  getMessageById(messageId:Number) {
    return this.http.get<Message>(`http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/messages/${messageId}`);
  }

  getAllMessagesByRecipientId(recipientId:Number) {
    return this.http.get<Message[]>(`http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/messages/recipient/${recipientId}`)
  }

  updateMessage(message:Message) {
    return this.http.put<Message>(`http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/messages/${message.messageId}`, message);
  }

  deleteMessage(messageId:Number) {
    return this.http.delete(`http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/messages/${messageId}`);
  }
}

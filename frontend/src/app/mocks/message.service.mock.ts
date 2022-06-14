import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import { Message } from 'src/entity/message';

@Injectable()
export class MessageServiceMock {
    constructor() {}

    getAllMessagesByRecipientId(): Observable<Message[]> {
        const message = [{
            messageId: 1,
            createdAt: new Date(),
            updatedAt: new Date(),
            messageContent: "test message",
            sender: {},
            recipient: {}
        }]
        return of(message);
    }
}
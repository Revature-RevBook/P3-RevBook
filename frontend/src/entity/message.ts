import { User } from "./user";

export interface Message {
    messageId: Number,
    createdAt: Date,
    updatedAt: Date,
    messageContent: String,
    sender: Partial<User>,
    recipient: Partial<User>
}
export interface Message {
    messageId: Number,
    createdAt: Date,
    updatedAt: Date,
    messageContent: String,
    senderId: Number,
    recipientId: Number
}
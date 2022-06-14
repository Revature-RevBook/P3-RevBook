import { User } from "./user";

export interface SubComment {
    subCommentId: Number,
    createdAt: Date,
    updatedAt: Date,
    subCommentContent: String,
    commenter: Partial<User>,
    commentId: Number
}
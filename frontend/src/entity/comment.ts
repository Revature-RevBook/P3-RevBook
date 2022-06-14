import { User } from "./user";

export interface Comment {
    commentId: Number,
    createdAt: Date,
    updatedAt: Date,
    commentContent: String,
    commenter: Partial<User>,
    postId: Number
}
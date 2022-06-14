import { User } from "./user";

export interface Post {
    postId: Number,
    postTitle: string,
    createdAt: Date,
    updatedAt: Date,
    postContent: string,
    postImgId: Number,
    user: Partial<User>
}
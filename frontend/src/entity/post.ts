import { User } from "./user";

export interface Post {
    postId: number,
    postTitle: string,
    createdAt: Date,
    updatedAt: Date,
    postContent: string,
    postImgId: Number,
    user: Partial<User>
}
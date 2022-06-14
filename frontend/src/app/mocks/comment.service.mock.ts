import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import { Comment } from 'src/entity/comment';

@Injectable()
export class CommentServiceMock {
    constructor() {}

    getAllCommentsByPostId(): Observable<Comment[]> {
        const comment = [{
            commentId: 1,
            createdAt: new Date(),
            updatedAt: new Date(),
            commentContent: 'test comment',
            commenter: {},
            postId: 1
        }]
        return of(comment);
    }
}
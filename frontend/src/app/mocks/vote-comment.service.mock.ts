import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import { VoteComment } from 'src/entity/vote-comment';

@Injectable()
export class VoteCommentServiceMock {
    constructor() {}

    getAllVoteCommentsByCommentId(): Observable<VoteComment[]> {
        const voteComment = [{
            voteId: 1,
            createdAt: new Date(),
            updatedAt: new Date(),
            vote: 5,
            commentId: 1,
            voterId: 1
            }]
        return of(voteComment);
    }
}
import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import { VotePost } from 'src/entity/vote-post';

@Injectable()
export class VotePostServiceMock {
    constructor() {}

    getAllVotesPostByPostId(): Observable<VotePost[]> {
        const votePost = [{
            voteId: 1,
            createdAt: new Date(),
            updatedAt: new Date(),
            vote: 5,
            postId: 1,
            voterId: 1
            }]
        return of(votePost);
    }
}
import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import { Post } from 'src/entity/post';

@Injectable()
export class PostServiceMock {
    constructor() {}

    getAllPosts(): Observable<Post[]> {
        const post = [{
                postId: 1,
                postTitle: 'test title',
                createdAt: new Date(),
                updatedAt: new Date(),
                postContent: 'test content',
                postImgId: 1,
                user: {}
            }]
        return of(post);
    }
}
import { TestBed } from '@angular/core/testing';
import { HttpClientModule} from '@angular/common/http';
import { VoteCommentService } from './vote-comment.service';

describe('VoteCommentService', () => {
  let service: VoteCommentService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule]
    });
    service = TestBed.inject(VoteCommentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';
import { HttpClientModule} from '@angular/common/http';
import { VotePostService } from './vote-post.service';

describe('VotePostService', () => {
  let service: VotePostService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule]
    });
    service = TestBed.inject(VotePostService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

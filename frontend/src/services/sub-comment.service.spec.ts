import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { SubCommentService } from './sub-comment.service';

describe('SubCommentService', () => {
  let service: SubCommentService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientModule]
    });
    service = TestBed.inject(SubCommentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

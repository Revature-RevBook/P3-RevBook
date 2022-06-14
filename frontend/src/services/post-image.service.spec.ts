import { TestBed } from '@angular/core/testing';
import { HttpClientModule} from '@angular/common/http';
import { PostImageService } from './post-image.service';

describe('PostImageService', () => {
  let service: PostImageService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule]
    });
    service = TestBed.inject(PostImageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { NO_ERRORS_SCHEMA } from '@angular/core';
import { TestBed } from '@angular/core/testing';

import { RequestInterceptor } from './request.interceptor';

describe('RequestInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      RequestInterceptor
      ],
      schemas: [NO_ERRORS_SCHEMA]
  }));

  it('should be created', () => {
    const interceptor: RequestInterceptor = TestBed.inject(RequestInterceptor);
    expect(interceptor).toBeTruthy();
  });
});

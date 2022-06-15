import { NO_ERRORS_SCHEMA } from '@angular/core';
import { TestBed } from '@angular/core/testing';
import {RouterTestingModule} from '@angular/router/testing'
import { AuthenticationGuard } from './authentication.guard';

describe('AuthenticationGuard', () => {

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      providers: [
        AuthenticationGuard
        ],
        schemas: [NO_ERRORS_SCHEMA]
    });
  });

  it('should be created', () => {
    const guard = TestBed.inject(AuthenticationGuard);
    expect(guard).toBeTruthy();
  });
});

import { TestBed, inject } from '@angular/core/testing';

import { AuthorApiService } from './author-api.service';

describe('AuthorApiService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AuthorApiService]
    });
  });

  it('should be created', inject([AuthorApiService], (service: AuthorApiService) => {
    expect(service).toBeTruthy();
  }));
});

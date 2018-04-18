import { TestBed, inject } from '@angular/core/testing';

import { BookApiService } from './book-api.service';

describe('BookApiService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BookApiService]
    });
  });

  it('should be created', inject([BookApiService], (service: BookApiService) => {
    expect(service).toBeTruthy();
  }));
});

import { TestBed, inject } from '@angular/core/testing';

import { AuthorStorageService } from './author-storage.service';

describe('AuthorStorageService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AuthorStorageService]
    });
  });

  it('should be created', inject([AuthorStorageService], (service: AuthorStorageService) => {
    expect(service).toBeTruthy();
  }));
});

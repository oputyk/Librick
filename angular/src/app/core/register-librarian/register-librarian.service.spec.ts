import { TestBed, inject } from '@angular/core/testing';

import { RegisterLibrarianService } from './register-librarian.service';

describe('RegisterLibrarianService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RegisterLibrarianService]
    });
  });

  it('should be created', inject([RegisterLibrarianService], (service: RegisterLibrarianService) => {
    expect(service).toBeTruthy();
  }));
});

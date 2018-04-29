import { TestBed, inject } from '@angular/core/testing';

import { AddBookDialogService } from './add-book-dialog.service';

describe('AddBookDialogService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AddBookDialogService]
    });
  });

  it('should be created', inject([AddBookDialogService], (service: AddBookDialogService) => {
    expect(service).toBeTruthy();
  }));
});

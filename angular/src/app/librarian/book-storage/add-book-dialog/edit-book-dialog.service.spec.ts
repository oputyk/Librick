import { TestBed, inject } from '@angular/core/testing';

import { EditBookDialogService } from './edit-book-dialog.service';

describe('EditBookDialogService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EditBookDialogService]
    });
  });

  it('should be created', inject([EditBookDialogService], (service: EditBookDialogService) => {
    expect(service).toBeTruthy();
  }));
});

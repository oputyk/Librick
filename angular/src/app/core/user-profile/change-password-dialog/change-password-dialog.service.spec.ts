import { TestBed, inject } from '@angular/core/testing';

import { ChangePasswordDialogService } from './change-password-dialog.service';

describe('ChangePasswordDialogService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ChangePasswordDialogService]
    });
  });

  it('should be created', inject([ChangePasswordDialogService], (service: ChangePasswordDialogService) => {
    expect(service).toBeTruthy();
  }));
});

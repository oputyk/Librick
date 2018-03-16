import { TestBed, inject } from '@angular/core/testing';

import { NavigationLinksProviderService } from './navigation-links-provider.service';

describe('NavigationLinksProviderService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [NavigationLinksProviderService]
    });
  });

  it('should be created', inject([NavigationLinksProviderService], (service: NavigationLinksProviderService) => {
    expect(service).toBeTruthy();
  }));
});

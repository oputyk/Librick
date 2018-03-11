import { TestBed, inject } from '@angular/core/testing';

import { TokenHttpInterceptorService } from './token-http-interceptor.service';

describe('TokenHttpInterceptorService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TokenHttpInterceptorService]
    });
  });

  it('should be created', inject([TokenHttpInterceptorService], (service: TokenHttpInterceptorService) => {
    expect(service).toBeTruthy();
  }));
});

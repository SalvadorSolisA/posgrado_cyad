import { TestBed } from '@angular/core/testing';

import { CyadService } from './cyad.service';

describe('CyadService', () => {
  let service: CyadService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CyadService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

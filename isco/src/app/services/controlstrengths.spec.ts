import { TestBed } from '@angular/core/testing';

import { ControlStrengthsService } from './controlstrengths.service';

describe('ControlstrengthsService', () => {
  let service: ControlStrengthsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ControlStrengthsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

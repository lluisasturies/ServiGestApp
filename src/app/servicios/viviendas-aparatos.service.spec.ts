import { TestBed } from '@angular/core/testing';

import { ViviendasAparatosService } from './viviendas-aparatos.service';

describe('ViviendasAparatosService', () => {
  let service: ViviendasAparatosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViviendasAparatosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

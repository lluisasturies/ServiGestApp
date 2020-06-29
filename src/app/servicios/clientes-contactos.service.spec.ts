import { TestBed } from '@angular/core/testing';

import { ClientesContactosService } from './clientes-contactos.service';

describe('ClientesContactosService', () => {
  let service: ClientesContactosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClientesContactosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

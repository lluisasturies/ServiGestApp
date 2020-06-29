import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddViviendaAparatoComponent } from './add-vivienda-aparato.component';

describe('AddViviendaAparatoComponent', () => {
  let component: AddViviendaAparatoComponent;
  let fixture: ComponentFixture<AddViviendaAparatoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddViviendaAparatoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddViviendaAparatoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

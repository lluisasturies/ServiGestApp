import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VerViviendaComponent } from './ver-vivienda.component';

describe('VerViviendaComponent', () => {
  let component: VerViviendaComponent;
  let fixture: ComponentFixture<VerViviendaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VerViviendaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VerViviendaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

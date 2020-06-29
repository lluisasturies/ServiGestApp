import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateViviendaComponent } from './update-vivienda.component';

describe('UpdateViviendaComponent', () => {
  let component: UpdateViviendaComponent;
  let fixture: ComponentFixture<UpdateViviendaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateViviendaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateViviendaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

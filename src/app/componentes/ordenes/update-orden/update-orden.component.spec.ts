import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateOrdenComponent } from './update-orden.component';

describe('UpdateOrdenComponent', () => {
  let component: UpdateOrdenComponent;
  let fixture: ComponentFixture<UpdateOrdenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateOrdenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateOrdenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

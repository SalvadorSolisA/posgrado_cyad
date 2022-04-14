import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProyectoRegisterComponent } from './proyecto-register.component';

describe('ProyectoRegisterComponent', () => {
  let component: ProyectoRegisterComponent;
  let fixture: ComponentFixture<ProyectoRegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProyectoRegisterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProyectoRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

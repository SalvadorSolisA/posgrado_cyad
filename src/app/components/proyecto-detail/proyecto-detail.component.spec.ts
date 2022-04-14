import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProyectoDetailComponent } from './proyecto-detail.component';

describe('ProyectoDetailComponent', () => {
  let component: ProyectoDetailComponent;
  let fixture: ComponentFixture<ProyectoDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProyectoDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProyectoDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlumnoDetailComponent } from './alumno-detail.component';

describe('AlumnoDetailComponent', () => {
  let component: AlumnoDetailComponent;
  let fixture: ComponentFixture<AlumnoDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlumnoDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AlumnoDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

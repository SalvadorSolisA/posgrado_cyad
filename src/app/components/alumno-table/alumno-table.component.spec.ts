import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlumnoTableComponent } from './alumno-table.component';

describe('AlumnoTableComponent', () => {
  let component: AlumnoTableComponent;
  let fixture: ComponentFixture<AlumnoTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlumnoTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AlumnoTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

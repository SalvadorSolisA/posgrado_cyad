import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatamartAlumnosTableComponent } from './datamart-alumnos-table.component';

describe('DatamartAlumnosTableComponent', () => {
  let component: DatamartAlumnosTableComponent;
  let fixture: ComponentFixture<DatamartAlumnosTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DatamartAlumnosTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DatamartAlumnosTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

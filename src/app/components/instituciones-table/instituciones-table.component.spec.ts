import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstitucionesTableComponent } from './instituciones-table.component';

describe('InstitucionesTableComponent', () => {
  let component: InstitucionesTableComponent;
  let fixture: ComponentFixture<InstitucionesTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstitucionesTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstitucionesTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstitucionesDetailComponent } from './instituciones-detail.component';

describe('InstitucionesDetailComponent', () => {
  let component: InstitucionesDetailComponent;
  let fixture: ComponentFixture<InstitucionesDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstitucionesDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstitucionesDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

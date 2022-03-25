import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstadoAspiranteDetailComponent } from './estado-aspirante-detail.component';

describe('EstadoAspiranteDetailComponent', () => {
  let component: EstadoAspiranteDetailComponent;
  let fixture: ComponentFixture<EstadoAspiranteDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EstadoAspiranteDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EstadoAspiranteDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

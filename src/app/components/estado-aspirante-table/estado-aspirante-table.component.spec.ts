import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstadoAspiranteTableComponent } from './estado-aspirante-table.component';

describe('EstadoAspiranteTableComponent', () => {
  let component: EstadoAspiranteTableComponent;
  let fixture: ComponentFixture<EstadoAspiranteTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EstadoAspiranteTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EstadoAspiranteTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DepartamentoTableComponent } from './departamento-table.component';

describe('DepartamentoTableComponent', () => {
  let component: DepartamentoTableComponent;
  let fixture: ComponentFixture<DepartamentoTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DepartamentoTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DepartamentoTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

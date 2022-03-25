import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstadoAcademicoTableComponent } from './estado-academico-table.component';

describe('EstadoAcademicoTableComponent', () => {
  let component: EstadoAcademicoTableComponent;
  let fixture: ComponentFixture<EstadoAcademicoTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EstadoAcademicoTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EstadoAcademicoTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

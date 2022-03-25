import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstadoAcademicoDetailComponent } from './estado-academico-detail.component';

describe('EstadoAcademicoDetailComponent', () => {
  let component: EstadoAcademicoDetailComponent;
  let fixture: ComponentFixture<EstadoAcademicoDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EstadoAcademicoDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EstadoAcademicoDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

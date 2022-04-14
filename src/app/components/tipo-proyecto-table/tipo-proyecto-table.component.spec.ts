import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipoProyectoTableComponent } from './tipo-proyecto-table.component';

describe('TipoProyectoTableComponent', () => {
  let component: TipoProyectoTableComponent;
  let fixture: ComponentFixture<TipoProyectoTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TipoProyectoTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TipoProyectoTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

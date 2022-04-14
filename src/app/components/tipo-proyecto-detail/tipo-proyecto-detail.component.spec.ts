import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipoProyectoDetailComponent } from './tipo-proyecto-detail.component';

describe('TipoProyectoDetailComponent', () => {
  let component: TipoProyectoDetailComponent;
  let fixture: ComponentFixture<TipoProyectoDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TipoProyectoDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TipoProyectoDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipoProduccionTableComponent } from './tipo-produccion-table.component';

describe('TipoProduccionTableComponent', () => {
  let component: TipoProduccionTableComponent;
  let fixture: ComponentFixture<TipoProduccionTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TipoProduccionTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TipoProduccionTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

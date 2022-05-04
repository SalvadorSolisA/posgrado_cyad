import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatamartHistorialTableComponent } from './datamart-historial-table.component';

describe('DatamartHistorialTableComponent', () => {
  let component: DatamartHistorialTableComponent;
  let fixture: ComponentFixture<DatamartHistorialTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DatamartHistorialTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DatamartHistorialTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

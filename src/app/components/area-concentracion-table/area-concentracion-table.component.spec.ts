import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AreaConcentracionTableComponent } from './area-concentracion-table.component';

describe('AreaConcentracionTableComponent', () => {
  let component: AreaConcentracionTableComponent;
  let fixture: ComponentFixture<AreaConcentracionTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AreaConcentracionTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AreaConcentracionTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

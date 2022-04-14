import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdenAutorTableComponent } from './orden-autor-table.component';

describe('OrdenAutorTableComponent', () => {
  let component: OrdenAutorTableComponent;
  let fixture: ComponentFixture<OrdenAutorTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrdenAutorTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdenAutorTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

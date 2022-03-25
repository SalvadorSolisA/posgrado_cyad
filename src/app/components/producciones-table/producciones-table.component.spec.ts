import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProduccionesTableComponent } from './producciones-table.component';

describe('ProduccionesTableComponent', () => {
  let component: ProduccionesTableComponent;
  let fixture: ComponentFixture<ProduccionesTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProduccionesTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProduccionesTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

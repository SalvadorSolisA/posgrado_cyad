import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfesorTableComponent } from './profesor-table.component';

describe('ProfesorTableComponent', () => {
  let component: ProfesorTableComponent;
  let fixture: ComponentFixture<ProfesorTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfesorTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfesorTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

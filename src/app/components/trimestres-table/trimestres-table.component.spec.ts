import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrimestresTableComponent } from './trimestres-table.component';

describe('TrimestresTableComponent', () => {
  let component: TrimestresTableComponent;
  let fixture: ComponentFixture<TrimestresTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrimestresTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrimestresTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

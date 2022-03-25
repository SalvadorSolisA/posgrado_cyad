import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LgacTableComponent } from './lgac-table.component';

describe('LgacTableComponent', () => {
  let component: LgacTableComponent;
  let fixture: ComponentFixture<LgacTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LgacTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LgacTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

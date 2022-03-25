import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NivelTableComponent } from './nivel-table.component';

describe('NivelTableComponent', () => {
  let component: NivelTableComponent;
  let fixture: ComponentFixture<NivelTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NivelTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NivelTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

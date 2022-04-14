import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AspiranteTableComponent } from './aspirante-table.component';

describe('AspiranteTableComponent', () => {
  let component: AspiranteTableComponent;
  let fixture: ComponentFixture<AspiranteTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AspiranteTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AspiranteTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

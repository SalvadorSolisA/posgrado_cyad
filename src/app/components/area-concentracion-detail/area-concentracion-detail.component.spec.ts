import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AreaConcentracionDetailComponent } from './area-concentracion-detail.component';

describe('AreaConcentracionDetailComponent', () => {
  let component: AreaConcentracionDetailComponent;
  let fixture: ComponentFixture<AreaConcentracionDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AreaConcentracionDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AreaConcentracionDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AspiranteDetailComponent } from './aspirante-detail.component';

describe('AspiranteDetailComponent', () => {
  let component: AspiranteDetailComponent;
  let fixture: ComponentFixture<AspiranteDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AspiranteDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AspiranteDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

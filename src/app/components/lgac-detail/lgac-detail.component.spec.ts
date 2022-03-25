import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LgacDetailComponent } from './lgac-detail.component';

describe('LgacDetailComponent', () => {
  let component: LgacDetailComponent;
  let fixture: ComponentFixture<LgacDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LgacDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LgacDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

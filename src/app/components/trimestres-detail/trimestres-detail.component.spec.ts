import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrimestresDetailComponent } from './trimestres-detail.component';

describe('TrimestresDetailComponent', () => {
  let component: TrimestresDetailComponent;
  let fixture: ComponentFixture<TrimestresDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrimestresDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrimestresDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

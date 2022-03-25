import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NivelDetailComponent } from './nivel-detail.component';

describe('NivelDetailComponent', () => {
  let component: NivelDetailComponent;
  let fixture: ComponentFixture<NivelDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NivelDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NivelDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

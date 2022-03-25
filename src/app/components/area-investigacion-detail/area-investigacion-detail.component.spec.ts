import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AreaInvestigacionDetailComponent } from './area-investigacion-detail.component';

describe('AreaInvestigacionDetailComponent', () => {
  let component: AreaInvestigacionDetailComponent;
  let fixture: ComponentFixture<AreaInvestigacionDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AreaInvestigacionDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AreaInvestigacionDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AreaInvestigacionTableComponent } from './area-investigacion-table.component';

describe('AreaInvestigacionTableComponent', () => {
  let component: AreaInvestigacionTableComponent;
  let fixture: ComponentFixture<AreaInvestigacionTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AreaInvestigacionTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AreaInvestigacionTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

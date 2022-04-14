import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdenAutorDetailComponent } from './orden-autor-detail.component';

describe('OrdenAutorDetailComponent', () => {
  let component: OrdenAutorDetailComponent;
  let fixture: ComponentFixture<OrdenAutorDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrdenAutorDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdenAutorDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

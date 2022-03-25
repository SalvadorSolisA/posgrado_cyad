import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProduccionesDetailComponent } from './producciones-detail.component';

describe('ProduccionesDetailComponent', () => {
  let component: ProduccionesDetailComponent;
  let fixture: ComponentFixture<ProduccionesDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProduccionesDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProduccionesDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

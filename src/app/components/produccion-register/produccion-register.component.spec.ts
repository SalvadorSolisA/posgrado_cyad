import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProduccionRegisterComponent } from './produccion-register.component';

describe('ProduccionRegisterComponent', () => {
  let component: ProduccionRegisterComponent;
  let fixture: ComponentFixture<ProduccionRegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProduccionRegisterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProduccionRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

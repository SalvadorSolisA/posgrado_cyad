import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipoClaveTableComponent } from './tipo-clave-table.component';

describe('TipoClaveTableComponent', () => {
  let component: TipoClaveTableComponent;
  let fixture: ComponentFixture<TipoClaveTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TipoClaveTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TipoClaveTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

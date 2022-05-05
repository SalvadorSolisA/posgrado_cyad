import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipoClaveDetailComponent } from './tipo-clave-detail.component';

describe('TipoClaveDetailComponent', () => {
  let component: TipoClaveDetailComponent;
  let fixture: ComponentFixture<TipoClaveDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TipoClaveDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TipoClaveDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

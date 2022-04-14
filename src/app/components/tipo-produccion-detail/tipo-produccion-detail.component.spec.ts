import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipoProduccionDetailComponent } from './tipo-produccion-detail.component';

describe('TipoProduccionDetailComponent', () => {
  let component: TipoProduccionDetailComponent;
  let fixture: ComponentFixture<TipoProduccionDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TipoProduccionDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TipoProduccionDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PainelPadraoComponent } from './painel-padrao.component';

describe('PainelPadraoComponent', () => {
  let component: PainelPadraoComponent;
  let fixture: ComponentFixture<PainelPadraoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PainelPadraoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PainelPadraoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

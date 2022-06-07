import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BootstrapFormatComponent } from './bootstrap-format.component';

describe('BootstrapFormatComponent', () => {
  let component: BootstrapFormatComponent;
  let fixture: ComponentFixture<BootstrapFormatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BootstrapFormatComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BootstrapFormatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

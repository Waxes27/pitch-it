import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InvestorPreferencesComponentComponent } from './investor-preferences-component.component';

describe('InvestorPreferencesComponentComponent', () => {
  let component: InvestorPreferencesComponentComponent;
  let fixture: ComponentFixture<InvestorPreferencesComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InvestorPreferencesComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InvestorPreferencesComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

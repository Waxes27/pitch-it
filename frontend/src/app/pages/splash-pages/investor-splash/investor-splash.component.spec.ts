import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InvestorSplashComponent } from './investor-splash.component';

describe('InvestorSplashComponent', () => {
  let component: InvestorSplashComponent;
  let fixture: ComponentFixture<InvestorSplashComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InvestorSplashComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InvestorSplashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

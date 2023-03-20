import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BillingSettingComponent } from './billing-setting.component';

describe('BillingSettingComponent', () => {
  let component: BillingSettingComponent;
  let fixture: ComponentFixture<BillingSettingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BillingSettingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BillingSettingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

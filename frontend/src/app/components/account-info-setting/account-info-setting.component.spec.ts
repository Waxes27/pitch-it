import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountInfoSettingComponent } from './account-info-setting.component';

describe('AccountInfoSettingComponent', () => {
  let component: AccountInfoSettingComponent;
  let fixture: ComponentFixture<AccountInfoSettingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AccountInfoSettingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AccountInfoSettingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusinessPreferencesComponentComponent } from './business-preferences-component.component';

describe('BusinessPreferencesComponentComponent', () => {
  let component: BusinessPreferencesComponentComponent;
  let fixture: ComponentFixture<BusinessPreferencesComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BusinessPreferencesComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BusinessPreferencesComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

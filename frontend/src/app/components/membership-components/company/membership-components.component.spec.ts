import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MembershipComponentsComponent } from './membership-components.component';

describe('MembershipComponentsComponent', () => {
  let component: MembershipComponentsComponent;
  let fixture: ComponentFixture<MembershipComponentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MembershipComponentsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MembershipComponentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

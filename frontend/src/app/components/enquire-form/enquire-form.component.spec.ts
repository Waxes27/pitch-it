import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnquireFormComponent } from './enquire-form.component';

describe('EnquireFormComponent', () => {
  let component: EnquireFormComponent;
  let fixture: ComponentFixture<EnquireFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnquireFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EnquireFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

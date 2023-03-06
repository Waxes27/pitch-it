import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PitchQuestionnaireComponent } from './pitch-questionnaire.component';

describe('PitchQuestionnaireComponent', () => {
  let component: PitchQuestionnaireComponent;
  let fixture: ComponentFixture<PitchQuestionnaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PitchQuestionnaireComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PitchQuestionnaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

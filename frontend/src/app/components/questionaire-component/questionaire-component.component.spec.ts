import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionaireComponentComponent } from './questionaire-component.component';

describe('QuestionaireComponentComponent', () => {
  let component: QuestionaireComponentComponent;
  let fixture: ComponentFixture<QuestionaireComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuestionaireComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(QuestionaireComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

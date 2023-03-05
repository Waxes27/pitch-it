import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";


@Component({
  selector: 'app-questionaire-component',
  templateUrl: './questionaire-component.component.html',
  styleUrls: ['./questionaire-component.component.sass']
})
export class QuestionaireComponentComponent implements OnInit {

  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  clickInvestor() {
    this.router.navigate(['/register/investor'])
  }

  clickBusiness() {
    this.router.navigate(['/register/company'])
  }

}

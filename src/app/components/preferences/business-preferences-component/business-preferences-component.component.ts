import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-business-preferences-component',
  templateUrl: './business-preferences-component.component.html',
  styleUrls: ['./business-preferences-component.component.sass']
})
export class BusinessPreferencesComponentComponent implements OnInit {
  industries = [
    "industry 1",
    "industry 2",
    "industry 3",
    "industry 4",
  ]

  locations = [
    "locale 1"
  ]

  businessStages = [
    "Idea",
    "Proof of concept",
    "Ready to go",
    "Trading"
  ]

  customerGroups = [
    "Group 1"
  ]

  investmentStages = [
    "Stage 1",
    "Stage 2"
  ]

  constructor() { }

  ngOnInit(): void {
  }

}

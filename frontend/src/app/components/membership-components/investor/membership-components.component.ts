import { DOCUMENT } from '@angular/common';
import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-membership-components',
  templateUrl: './membership-components.component.html',
  styleUrls: ['./membership-components.component.sass']
})
export class InvestorMembershipComponentsComponent implements OnInit {
  
  constructor(private route: Router,@Inject(DOCUMENT) private document: Document) { }

  onSubmit() {
    console.log("Submitting and redirecting");
    this.document.location.href = "https://buy.stripe.com/bIYaIscSJa2t3047ss";
  }

  ngOnInit(): void {
  }

}

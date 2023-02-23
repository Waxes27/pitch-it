import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-membership-components',
  templateUrl: './membership-components.component.html',
  styleUrls: ['./membership-components.component.sass']
})
export class CompanyMembershipComponentsComponent implements OnInit {
onSubmit() {
  console.log("Submitting and redirecting");
  
}

  constructor() { }

  ngOnInit(): void {
  }

}

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FormDataService } from 'src/app/services/FormDataService';

@Component({
  selector: 'app-market-details',
  templateUrl: './market-details.component.html',
  styleUrls: ['./market-details.component.sass']
})
export class MarketDetailsComponent implements OnInit {

  memberDetailsForm = new FormGroup({
    marketResearch: new FormControl('',[<any>Validators.required]),
    advantages: new FormControl('', [<any>Validators.required]),
  });

  constructor(private formDataService: FormDataService ,private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    let data = {
      marketDetails: this.memberDetailsForm.value
    }

    this.formDataService.updateData(data);
    console.log(this.formDataService.currentData);
    this.router.navigate(["/pitch/new/team-details"]);
    }

  

}

import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-investor-preferences-component',
  templateUrl: './investor-preferences-component.component.html',
  styleUrls: ['./investor-preferences-component.component.sass']
})
export class InvestorPreferencesComponentComponent implements OnInit {
  industries = [
    "industry 1",
    "industry 2",
    "industry 3",
    "industry 4",
  ]

  locations = [
    "locale 1"
  ]

  productStages = [
    "Development",
    "Finished"
  ]

  customerGroups = [
    "Group 1"
  ]

  investmentStages = [
    "Stage 1",
    "Stage 2"
  ]


  constructor() { }
  
  registrationForm = new FormGroup({
    name: new FormControl('',[<any>Validators.required]),
    surname: new FormControl('', [<any>Validators.required]),
    DOB: new FormControl('', [<any>Validators.required, Validators.pattern("")]),
    username: new FormControl('', [<any>Validators.required, <any>Validators.minLength(6)]),
    password: new FormControl('', [<any>Validators.required, <any>Validators.minLength(8)]),
    role: new FormControl('')
  });

  ngOnInit(): void {
  }

  onSubmit():void{
    
  }

}

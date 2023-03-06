import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-company-details',
  templateUrl: './company-details.component.html',
  styleUrls: ['./company-details.component.sass']
})
export class CompanyDetailsComponent implements OnInit {
  registrationForm = new FormGroup({
    name: new FormControl('',[<any>Validators.required]),
    surname: new FormControl('', [<any>Validators.required]),
    DOB: new FormControl('', [<any>Validators.required, Validators.pattern("")]),
    username: new FormControl('', [<any>Validators.required, <any>Validators.minLength(6)]),
    password: new FormControl('', [<any>Validators.required, <any>Validators.minLength(8)]),
    role: new FormControl('')
  });

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(){}

}

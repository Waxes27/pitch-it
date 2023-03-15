import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-enquire-form',
  templateUrl: './enquire-form.component.html',
  styleUrls: ['./enquire-form.component.sass']
})
export class EnquireFormComponent implements OnInit {

enquireForm = new FormGroup({
  name: new FormControl('', [<any>Validators.required, <any>Validators.minLength(6)]),
  email: new FormControl('', [<any>Validators.required, <any>Validators.minLength(8)]),
  phone: new FormControl('', [<any>Validators.required, <any>Validators.minLength(8)]),
  message: new FormControl('', [<any>Validators.required, <any>Validators.minLength(8)]),
});

onSubmit() {
}

  constructor() { }

  ngOnInit(): void {
  }

}

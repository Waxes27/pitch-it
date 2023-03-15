import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-invest',
  templateUrl: './invest.component.html',
  styleUrls: ['./invest.component.sass']
})
export class InvestComponent implements OnInit {
investForm = new FormGroup({
  amount: new FormControl('', [<any>Validators.required, <any>Validators.minLength(6)]),
});
sharePrice = 3.115588
shareCompare = parseInt(this.investForm.value.amount!) / this.sharePrice

onSubmit() {
}

calculateShare(){
  return parseInt(this.investForm.value.amount!) / this.sharePrice
}

  constructor() { }

  ngOnInit(): void {
  }

}

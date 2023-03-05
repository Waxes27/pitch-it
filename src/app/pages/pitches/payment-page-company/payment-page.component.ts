import { Component, OnInit } from "@angular/core";
import { FormGroup, FormControl } from "@angular/forms";

@Component({
  selector: "app-payment-page",
  templateUrl: "./payment-page.component.html",
  styleUrls: ["./payment-page.component.sass"],
})
export class PaymentPageComponent implements OnInit {
  
name: string = "";
  number: string = "";
  cvc: string = "";
  expiry: string = "";


  constructor() {}

  ngOnInit(): void {}

}

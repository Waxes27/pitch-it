import { DOCUMENT } from "@angular/common";
import { Component, Inject, OnInit } from "@angular/core";
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


  constructor(@Inject(DOCUMENT) private document: Document) {}

  ngOnInit(): void {}

  platinum(){
    this.document.location.href = "https://buy.stripe.com/6oE8Ak2e55Md6cg9AB"
  }

}

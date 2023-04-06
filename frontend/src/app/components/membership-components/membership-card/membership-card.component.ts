import { DOCUMENT } from "@angular/common";
import { Component, Inject, Input, OnInit } from "@angular/core";

@Component({
  selector: "app-membership-card",
  templateUrl: "./membership-card.component.html",
  styleUrls: ["./membership-card.component.sass"],
})
export class MembershipCardComponent implements OnInit {

resolve() {
  this.package = this.package.toLowerCase()
  console.log(this.package == "platinum");
  
  if (this.package == "platinum"){
    this.document.location.href = "https://buy.stripe.com/6oE8Ak2e55Md6cg9AB"
  }else if(this.package == "advanced"){
    this.document.location.href = "https://buy.stripe.com/aEUg2M3i9a2t58c4gi"
  }else if(this.package == "investor"){
    this.document.location.href = "https://buy.stripe.com/bIYaIscSJa2t3047ss"}
    else{
    this.document.location.href = "https://buy.stripe.com/00g2bW7yp6Qh4487sv"
  }
}
  @Input() perks: string[] = [];
  @Input() price: number = 0;
  @Input() package: string = "";
  constructor(@Inject(DOCUMENT) private document: Document) {}

  ngOnInit(): void {}

  
}

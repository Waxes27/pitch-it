import { Component, Input, OnInit } from "@angular/core";

@Component({
  selector: "app-membership-card",
  templateUrl: "./membership-card.component.html",
  styleUrls: ["./membership-card.component.sass"],
})
export class MembershipCardComponent implements OnInit {
  @Input() perks: string[] = [];
  @Input() price: number = 0;
  @Input() package: string = "";
  constructor() {}

  ngOnInit(): void {}
}

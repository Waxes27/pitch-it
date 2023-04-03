import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";

@Component({
  selector: "app-business-details",
  templateUrl: "./business-details.component.html",
  styleUrls: ["./business-details.component.sass"],
})
export class BusinessDetailsComponent implements OnInit {
  businessDetails = new FormGroup({
    product: new FormControl("", [<any>Validators.required]),
    problemSolved: new FormControl("", [<any>Validators.required]),
    businessModel: new FormControl("", [<any>Validators.required]),
    raising: new FormControl("", [<any>Validators.required]),
  });

  constructor(private router: Router) {}

  ngOnInit(): void {}

  onSubmit() {
    this.router.navigate(["/pitch/new/market-details"]);
  }
}

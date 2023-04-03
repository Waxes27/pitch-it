import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { FormDataService } from "src/app/services/FormDataService";

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

  constructor(private formDataService: FormDataService ,private router: Router) {}

  ngOnInit(): void {}

  onSubmit() {
    let data = {
      businessDetails: this.businessDetails.value
    }
    this.formDataService.updateData(data);
    console.log(this.formDataService.currentData);
    this.router.navigate(["/pitch/new/market-details"]);
  }
}

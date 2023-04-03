import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { FormDataService } from "src/app/services/FormDataService";

@Component({
  selector: "app-company-details",
  templateUrl: "./company-details.component.html",
  styleUrls: ["./company-details.component.sass"],
})
export class CompanyDetailsComponent implements OnInit {
  companyDetails = new FormGroup({
    name: new FormControl("", [<any>Validators.required]),
    registrationNumber: new FormControl("", [<any>Validators.required]),
    website: new FormControl("", [<any>Validators.required]),
    instagram: new FormControl("", [<any>Validators.required]),
    twitter: new FormControl("", [<any>Validators.required]),
    facebook: new FormControl("", [<any>Validators.required]),
    linkedin: new FormControl("", [<any>Validators.required]),
    growthStage: new FormControl("", [<any>Validators.required]),
    country: new FormControl("", [<any>Validators.required]),
    companyName: new FormControl("", [<any>Validators.required]),
    sector: new FormControl("", [<any>Validators.required]),
  });

  constructor(private formDataService: FormDataService, private router: Router) {}

  ngOnInit(): void {}

  onSubmit() {
    let data = {
      companyDetails: this.companyDetails.value
    }
    this.formDataService.updateData(data);
    console.log(this.formDataService.currentData);
    this.router.navigate(["/pitch/new/business-details"]);
  }
}

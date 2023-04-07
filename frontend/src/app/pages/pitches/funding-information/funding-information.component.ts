import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { FormDataService } from "src/app/services/FormDataService";

@Component({
  selector: "app-funding-information",
  templateUrl: "./funding-information.component.html",
  styleUrls: ["./funding-information.component.sass"],
})
export class FundingInformationComponent {
  fundingForm = new FormGroup({
    raiseAmount: new FormControl("", [<any>Validators.required]),
    equityOffered: new FormControl("", [<any>Validators.required]),
    trailer: new FormControl("", [<any>Validators.required]),
  });

  constructor(
    private http: HttpClient,
    private router: Router,
    private formDataService: FormDataService
  ) {}

  onSubmit() {
    let finalRequest = this.formDataService.createObjectFromEntries();
    console.log(this.formDataService.currentData)
    console.log(finalRequest);
    
    
    
    this.http.post("http://102.221.36.216:8081/api/pitch?userId=waxes27", finalRequest).subscribe((data) => {
      console.log(data);
    });
  }
}

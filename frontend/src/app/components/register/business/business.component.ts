import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";

@Component({
  selector: "app-business",
  templateUrl: "./business.component.html",
  styleUrls: ["./business.component.sass"],
})
export class BusinessComponent implements OnInit {
  error: string = "";
  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit(): void {}

  roles = ["Investor", "Business"];

  registrationForm = new FormGroup({
    name: new FormControl("", [<any>Validators.required]),
    surname: new FormControl("", [<any>Validators.required]),
    username: new FormControl("", [
      <any>Validators.required,
      <any>Validators.minLength(6),
    ]),

    email: new FormControl("", [
      <any>Validators.required,
      <any>Validators.email,
    ]),
    password: new FormControl("", [
      <any>Validators.required,
      <any>Validators.minLength(8),
    ]),
    confirmedPassword: new FormControl("", [
      <any>Validators.required,
      <any>Validators.minLength(8),
    ]),
    businessRole: new FormControl("", [<any>Validators.required]),
  });

  onSubmit() {
    let body = {
      businessName: this.registrationForm.get("name")?.value,
      representativeFirstName: this.registrationForm.get("name")?.value,
      representativeLastName: this.registrationForm.get("surname")?.value,
      businessRole: this.registrationForm.get("businessRole")?.value,
      email: this.registrationForm.get("email")?.value,
      password: this.registrationForm.get("password")?.value,
    };


    let passowrdsMatch: boolean =
      this.registrationForm.get("password")?.value ===
      this.registrationForm.get("confirmedPassword")?.value;
    if (body && passowrdsMatch) {
      this.http
        .post("http://102.221.36.216:8081/register/business", body, {withCredentials: true})
        .subscribe(
          (data: object) => {
            console.log(data);

            if (data) {
              this.router.navigate(["preferences/business"]);
            }
          },
          (error: HttpErrorResponse) => {
            this.error = error.error;
            console.log(error);
          }
        );
    } else {
      this.error = "The passwords don't match";
    }
  }
}

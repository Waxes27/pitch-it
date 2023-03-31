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
    DOB: new FormControl("", [
      <any>Validators.required,
      Validators.pattern(""),
    ]),
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
    role: new FormControl(""),
  });

  onSubmit() {
    let body = {
      representativeFirstName: this.registrationForm.get("name")?.value,
      name: this.registrationForm.get("name")?.value,
      representativeLastName: this.registrationForm.get("surname")?.value,
      email: this.registrationForm.get("email")?.value,
      DOB: "03/05/2023",
      username: "babs",
      password: this.registrationForm.get("password")?.value,
      confirmedPassword: this.registrationForm.get("confirmedPassword")?.value,
      representativeRole: "Business",
    };
    let passowrdsMatch: boolean =
      this.registrationForm.get("password")?.value ===
      this.registrationForm.get("confirmedPassword")?.value;
    if (body && passowrdsMatch) {
      this.http
        .post("http://localhost:8080/api/business/sign-up", body)
        .subscribe(
          (data: object) => {
            if (data) {
              this.router.navigate(["preferences/business"]);
            }
          },
          (error: HttpErrorResponse) => {
            this.error = error.error;
          }
        );
    }else{
      this.error = "The passwords don't match"
    }
  }
}

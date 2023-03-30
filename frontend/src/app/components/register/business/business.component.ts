import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";

@Component({
  selector: "app-business",
  templateUrl: "./business.component.html",
  styleUrls: ["./business.component.sass"],
})
export class BusinessComponent implements OnInit {
  constructor(private http: HttpClient) {}

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
      <any>Validators.email
    ]),
    password: new FormControl("", [
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
      password: "ihsbnb",
      representativeRole: "Business",
    };

    let httpOptions = {
      header: new HttpHeaders({
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*",
      }),
      body: JSON.stringify(body),
    };

    this.http
      .post("http://localhost:8080/api/business/sign-up", body)
      .subscribe((data) => {
        console.log(data);
      });
  }
}

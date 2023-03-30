import { HttpClient } from "@angular/common/http";
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
    password: new FormControl("", [
      <any>Validators.required,
      <any>Validators.minLength(8),
    ]),
    role: new FormControl(""),
  });

  onSubmit() {
  
    let body = {
      name: this.registrationForm.get("name")?.value,
      surname: this.registrationForm.get("surname")?.value,
      DOB: this.registrationForm.get("DOB")?.value,
      username: this.registrationForm.get("username")?.value,
      password: this.registrationForm.get("password")?.value,
      role: "Business"
    };


    this.http
      .post("http://localhost:8080/api/business/sign-up", body)
      .subscribe((data) => {
        console.log(data);
      });
  }
}

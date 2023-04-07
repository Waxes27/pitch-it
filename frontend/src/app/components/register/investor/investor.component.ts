import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { HttpClient } from "@angular/common/http";
import { AuthService } from "src/app/auth/auth.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-investor",
  templateUrl: "./investor.component.html",
  styleUrls: ["./investor.component.sass"],
})
export class InvestorComponent implements OnInit {
  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit(): void {}

  roles = ["Investor", "Business"];

  registrationForm = new FormGroup({
    firstName: new FormControl("", [<any>Validators.required]),
    lastName: new FormControl("", [<any>Validators.required]),

    email: new FormControl("", [<any>Validators.required]),
    password: new FormControl("", [
      <any>Validators.required,
      <any>Validators.minLength(8),
    ]),
    confirmPassword: new FormControl("", [
      <any>Validators.required,
      <any>Validators.minLength(8),
    ]),
  });


  onSubmit() {

    let body = {
      firstName: this.registrationForm.get("firstName")?.value,
      lastName: this.registrationForm.get("lastName")?.value,
      email: this.registrationForm.get("email")?.value,
      password: this.registrationForm.get("password")?.value,
    
    };

    this.http
      .post("http://102.221.36.216:8081/register/investor", body, {withCredentials: true})
      .subscribe((data) => {
        console.log(data);
        this.router.navigate(["membership/investor"])
      });
  }
}

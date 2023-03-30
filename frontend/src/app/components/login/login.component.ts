import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { AuthService } from "src/app/auth/auth.service";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.sass"],
})
export class LoginComponent implements OnInit {
  constructor(private http: HttpClient, private auth: AuthService) {}

  ngOnInit(): void {}

  loginForm = new FormGroup({
    username: new FormControl("", [
      <any>Validators.required,
      <any>Validators.minLength(6),
    ]),
    password: new FormControl("", [
      <any>Validators.required,
      <any>Validators.minLength(8),
    ]),
  });

  onSubmit() {
    let formData = {
      username: this.loginForm.get("username")?.value,
      passwird: this.loginForm.get("password")?.value,
    };
    let httpOptions = {
      header: new HttpHeaders({
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*",
      }),
      body: JSON.stringify(formData)
    };
    this.http
      .post("http://localhost:8080/api/business/sign-in", httpOptions)
      .subscribe((data) => {
        console.log(data);
      });
  }
}

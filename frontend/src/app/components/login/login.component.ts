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
      password: this.loginForm.get("password")?.value,
    };

    console.log(formData);
    
    this.http
      .post(`http://localhost:8081/login?username=${formData.username}.com&password=${formData.password}`, formData)
      .subscribe((data) => {
        console.log(data);
      });
  }
}

import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { AuthService } from "src/app/auth/auth.service";
import { Router } from "@angular/router";
import { UserDataService } from "src/app/services/UserDataService";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.sass"],
})
export class LoginComponent implements OnInit {
  constructor(private http: HttpClient, private router: Router, private userService: UserDataService) {}

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
    
    this.http
      .post(`http://localhost:8081/login?username=${formData.username}&password=${formData.password}`, formData)
      .subscribe((data: any) => {
        let userData = {
          firstName: data.firstName,
          lastName: data.lastName,
          title: data.role,
          location: "UK",
          about: ""
        }
        this.userService.updateUser(userData)

        this.router.navigate(["/home"])
      });
  }
}

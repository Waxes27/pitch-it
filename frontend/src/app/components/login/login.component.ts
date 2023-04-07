import {Component, OnInit} from "@angular/core";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {UserDataService} from "src/app/services/UserDataService";
import {CookieService} from "ngx-cookie-service";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.sass"],
})
export class LoginComponent implements OnInit {
  constructor(
    private http: HttpClient,
    private router: Router,
    private userService: UserDataService,
    private cookies: CookieService
  ) {}

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
      .post(
        `http://102.221.36.216:8081/login?username=${formData.username}&password=${formData.password}`,
        formData,
        { withCredentials: true }
      )
      .subscribe((data: any) => {
        let userData = {
          firstName: data.representativeFirstName,
          lastName: data.representativeLastName,
          title: data.role,
          location: "UK",
          about: "",
        };
        this.cookies.set("userEmail", data.email);
        this.userService.updateUser(userData);
        this.router.navigate(["/home"]);
      });
  }
}

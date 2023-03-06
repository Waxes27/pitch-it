import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
@Injectable({
  providedIn: "root",
})
export class AuthService {
  public redirectUrl: string = "";

  isLoggedIn = false;
  constructor(private router: Router, private http: HttpClient) {}

  isAuthenticated() {
    return this.isLoggedIn;
  }

  authenticate() {
    this.isLoggedIn = true;
  }

  login(formData: FormData) {
    // TODO

    // return this.http.post("api/login", formData).subscribe({
    //   next: (res) => {
    //     this.isLoggedIn = true;
    //     if (this.redirectUrl != "") {
    //       this.router.navigate([this.redirectUrl]);
    //       this.redirectUrl = "";
    //     }
    //   },
    //   error: (err) => {
    //     console.log("Tryna login");
    //   },
    // });
    this.isLoggedIn = true;
    return true;
  }


  registerInvestor(formData: FormData){
    this.isLoggedIn = true;
    this.router.navigate(["/preferences/investor"])
    

    return true;
  }

  registerBusiness(formData: FormData){
    this.isLoggedIn = true;
    this.router.navigate(["/preferences/business"])
    

    return true;
  }

  logout(): void {
    this.isLoggedIn = false;
  }
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';
import {IUser} from "../../interfaces/IUser";
import {InvestorUserModel} from "../../models/InvestorUser";
import {CookieService} from "ngx-cookie-service";
import {BusinessUserModel} from "../../models/BusinessUserModel";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: "app-main-component",
  templateUrl: "./main-component.component.html",
  styleUrls: ["./main-component.component.sass"],
})
export class MainComponentComponent implements OnInit {
  user: IUser = new InvestorUserModel();
  constructor(public auth: AuthService, private router: Router, private cookies: CookieService, private http: HttpClient) {}
goToChat() {
  window.location.href = 'http://pitchitltd.co.uk:3000/login';
}


  // constructor(public auth: AuthService, private router: Router) {}
  routesList = [
    "/",
    "/questionaire",
    "/login",
    "/register/investor",
    "/preferences/investor",
    "/register/business",
    "/preferences/business",
    "/membership",
    "/splash",
    "/register",
    "/membership/investor",
    "/payment",
    "/membership/company",
    "/settings",
  ];
  checkRoute() {
    for (var key in this.routesList) {
      // console.log(this.routesList[key]);

      if (this.router.url == this.routesList[key]) {
        // console.log("true and equal");

        return true;
      }
    }
    return false;
  }

  ngOnInit(): void {
    this.http
        .get(
            `http://102.221.36.216:8081/user/${this.cookies.get("userEmail")}`,
            {withCredentials: true}
        )
        .subscribe((data: any): void => {
          if (data.role.toLowerCase() === "investor") {
            this.user = new InvestorUserModel(data);
          } else {
            this.user = new BusinessUserModel(data);
          }
        });
  }
}

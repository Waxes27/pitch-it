import {Component, OnInit} from '@angular/core';
import {IUser} from "../../interfaces/IUser";
import {InvestorUserModel} from "../../models/InvestorUser";
import {Router} from "@angular/router";
import {CookieService} from "ngx-cookie-service";
import {HttpClient} from "@angular/common/http";
import {BusinessUserModel} from "../../models/BusinessUserModel";

@Component({
    selector: 'app-splash',
    templateUrl: './splash.component.html',
    styleUrls: ['./splash.component.sass']
})
export class SplashComponent implements OnInit {

    user: IUser = new InvestorUserModel();

    constructor(private router: Router, private cookies: CookieService, private http: HttpClient) {
    }

    async ngOnInit(): Promise<void> {
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
        await new Promise(f => setTimeout(f, 2500));
        this.router.navigate(["/home"])

    }

}

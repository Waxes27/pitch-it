import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {InvestorUserModel} from "../../../models/InvestorUser";
import {BusinessUserModel} from "../../../models/BusinessUserModel";
import {CookieService} from "ngx-cookie-service";
import {HttpClient} from "@angular/common/http";
import {IUser} from "../../../interfaces/IUser";

@Component({
    selector: 'app-investor-splash',
    templateUrl: './investor-splash.component.html',
    styleUrls: ['./investor-splash.component.sass']
})
export class InvestorSplashComponent implements OnInit {
    user: IUser = new InvestorUserModel();

    constructor(private router: Router, private cookies: CookieService, private http: HttpClient) {
    }

    async ngOnInit(): Promise<void> {
        this.http
            .get(
                `http://pitchitltd.co.uk:8081/user/${this.cookies.get("userEmail")}`,
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

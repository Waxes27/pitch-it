import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CompanyDetailsModel} from "../../models/CompanyDetailsModel";
import {BusinessDetailsModel} from "../../models/BusinessDetailsModel";
import {MarketDetailsModel} from "../../models/MarketDetailsModel";
import {MemberDetails} from "../../models/MemberDetails";
import {PitchModel} from "../../models/PitchModel";
import {Router} from "@angular/router";
import {IUser} from "../../interfaces/IUser";
import {InvestorUserModel} from "../../models/InvestorUser";
import {BusinessUserModel} from "../../models/BusinessUserModel";
import {CookieService} from "ngx-cookie-service";

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.sass']
})
export class HomeComponent implements OnInit {
    pitches: PitchModel[] = [];


    constructor(private http: HttpClient, private router: Router, private cookies: CookieService) {
    }

    public goToPitchPage(id: number): void {
        this.router.navigate([`/pitch/${id}`])
    }

    ngOnInit(): void {

        this.http.get("http://102.221.36.216:8081/api/pitch/all", {withCredentials: true}).subscribe((receivedPitches: any) => {

            for (let i: number = 0; i < receivedPitches.length; i++) {
                let pitchData = receivedPitches[i];
                let companyDetails: CompanyDetailsModel = new CompanyDetailsModel(pitchData.companyDetails);
                let businessDetails: BusinessDetailsModel = new BusinessDetailsModel(pitchData.businessDetails);
                let marketDetails: MarketDetailsModel = new MarketDetailsModel(pitchData.marketDetails);
                let memberDetails: MemberDetails = new MemberDetails(pitchData.memberDetails);
                let pitch: PitchModel = new PitchModel(pitchData.id, companyDetails, businessDetails, marketDetails, memberDetails);
                this.pitches.push(pitch);
            }
        })
    }

}

import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {CompanyDetailsModel} from "../../models/CompanyDetailsModel";
import {BusinessDetailsModel} from "../../models/BusinessDetailsModel";
import {MarketDetailsModel} from "../../models/MarketDetailsModel";
import {MemberDetails} from "../../models/MemberDetails";
import {PitchModel} from "../../models/PitchModel";
import {IUser} from "../../interfaces/IUser";
import {InvestorUserModel} from "../../models/InvestorUser";
import {CookieService} from "ngx-cookie-service";
import {BusinessUserModel} from "../../models/BusinessUserModel";

@Component({
    selector: 'app-pitch-page',
    templateUrl: './pitch-page.component.html',
    styleUrls: ['./pitch-page.component.sass']
})
export class PitchPageComponent implements OnInit {
    private pitchId?: number;
    pitch: PitchModel = new PitchModel();
    user: IUser = new InvestorUserModel();


    constructor(private route: ActivatedRoute, private router: Router, private cookies: CookieService, private http: HttpClient) {

    }

    ngOnInit(): void {
        this.pitchId = parseInt(<string>this.route.snapshot.paramMap.get("id"));

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

        this.http.get(`http://pitchitltd.co.uk:8081/api/pitch/id?id=${this.pitchId}`, {withCredentials: true}).subscribe((pitchData: any): void => {
            console.log(pitchData)
            let companyDetails: CompanyDetailsModel = new CompanyDetailsModel(pitchData.companyDetails);
            let businessDetails: BusinessDetailsModel = new BusinessDetailsModel(pitchData.businessDetails);
            let marketDetails: MarketDetailsModel = new MarketDetailsModel(pitchData.marketDetails);
            let memberDetails: MemberDetails = new MemberDetails(pitchData.memberDetails);
            let pitch: PitchModel = new PitchModel(pitchData.id, companyDetails, businessDetails, marketDetails, memberDetails);
            this.pitch = pitch
        })
    }

}

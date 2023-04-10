import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CompanyDetailsModel} from "../../models/CompanyDetailsModel";
import {BusinessDetailsModel} from "../../models/BusinessDetailsModel";
import {MarketDetailsModel} from "../../models/MarketDetailsModel";
import {MemberDetails} from "../../models/MemberDetails";
import {PitchModel} from "../../models/PitchModel";

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.sass']
})
export class HomeComponent implements OnInit {
    pitches: PitchModel[] = [];

    constructor(private http: HttpClient) {
    }

    ngOnInit(): void {
        this.http.get("http://102.221.36.216:8081/api/pitch/all", {withCredentials: true}).subscribe((receivedPitches: any) => {

            for (let i:number = 0; i < receivedPitches.length; i++) {
                let pitchData = receivedPitches[i];
                let companyDetails: CompanyDetailsModel = new CompanyDetailsModel(pitchData.companyDetails);
                let businessDetails: BusinessDetailsModel = new BusinessDetailsModel(pitchData.businessDetails);
                let marketDetails: MarketDetailsModel = new MarketDetailsModel(pitchData.marketDetails);
                let memberDetails: MemberDetails = new MemberDetails(pitchData.memberDetails);
                let pitch: PitchModel = new PitchModel(companyDetails, businessDetails, marketDetails, memberDetails);
                this.pitches.push(pitch);
            }

            console.log(this.pitches);
        })
    }

}

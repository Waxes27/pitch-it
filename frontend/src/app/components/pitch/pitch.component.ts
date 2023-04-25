import {Component, Input, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CompanyDetailsModel} from "../../models/CompanyDetailsModel";
import {BusinessDetailsModel} from "../../models/BusinessDetailsModel";
import {MarketDetailsModel} from "../../models/MarketDetailsModel";
import {MemberDetails} from "../../models/MemberDetails";
import {PitchModel} from "../../models/PitchModel";

@Component({
    selector: 'app-pitch',
    templateUrl: './pitch.component.html',
    styleUrls: ['./pitch.component.sass']
})
export class PitchComponent implements OnInit {

    @Input() title: string = '';
    @Input() body: string = '';
    @Input() id: number = 0;
    pitch: PitchModel = new PitchModel()


    constructor(private http: HttpClient) {
    }

    ngOnInit(): void {
        this.http.get(`http://pitchitltd.co.uk:8081/api/pitch/id?id=${this.id}`, {withCredentials: true}).subscribe((pitchData: any): void => {
            console.log(pitchData)
            let companyDetails: CompanyDetailsModel = new CompanyDetailsModel(pitchData.companyDetails);
            let businessDetails: BusinessDetailsModel = new BusinessDetailsModel(pitchData.businessDetails);
            let marketDetails: MarketDetailsModel = new MarketDetailsModel(pitchData.marketDetails);
            let memberDetails: MemberDetails = new MemberDetails(pitchData.memberDetails);
            this.pitch = new PitchModel(pitchData.id, pitchData.logoUrl, companyDetails, businessDetails, marketDetails, memberDetails)
        })
    }


}

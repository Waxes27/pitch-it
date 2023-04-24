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
import {finalize} from "rxjs";
import {AngularFireStorage} from "@angular/fire/compat/storage";

@Component({
    selector: 'app-pitch-page',
    templateUrl: './pitch-page.component.html',
    styleUrls: ['./pitch-page.component.sass']
})
export class PitchPageComponent implements OnInit {
    private pitchId?: number;
    pitch: PitchModel = new PitchModel();
    user: IUser = new InvestorUserModel();
    selectedFile: File | null = null;


    constructor(private route: ActivatedRoute, private router: Router, private cookies: CookieService, private http: HttpClient, private storage: AngularFireStorage) {

    }

    onFileSelected(event: any) {
        this.selectedFile = event.target.files[0];
        console.log(this.selectedFile?.name)
    }

    uploadFile() {
        const filePath = `pitches/logos/${this.pitch.id}.png`;

        // Create a reference to the file path in Firebase Storage
        const fileRef = this.storage.ref(filePath);

        // Upload the file to Firebase Storage and get the upload task
        const uploadTask = fileRef.put(this.selectedFile);


        uploadTask.percentageChanges().subscribe(progress => {
            console.log(`Upload is ${progress}% done`);
        });

        uploadTask.snapshotChanges().pipe(
            finalize(() => {
                fileRef.getDownloadURL().subscribe(url => {
                    console.log('File uploaded to:', url);
                });
            })
        ).subscribe();

        fileRef.getDownloadURL().subscribe(url => {
            let newUrl = url
            let body = {
                "pictureUrl": newUrl
            }

            this.http.post(`http://pitchitltd.co.uk:8081/profile?email=${this.cookies.get('userEmail')}`,
                {
                    withCredentials: true,
                    "pictureUrl": newUrl,
                }
            ).subscribe(data => {
                console.log(data)
            })
        })
    }

    ngOnInit(): void {
        this.pitchId = parseInt(<string>this.route.snapshot.paramMap.get("id"));

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

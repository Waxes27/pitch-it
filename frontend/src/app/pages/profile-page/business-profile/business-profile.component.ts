import {HttpClient} from "@angular/common/http";
import {Component, OnInit} from "@angular/core";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CookieService} from "ngx-cookie-service";
import {InvestorUserModel} from "src/app/models/InvestorUser";
import {IUser} from "../../../interfaces/IUser";
import {BusinessUserModel} from "../../../models/BusinessUserModel";
import {AngularFireStorage} from "@angular/fire/compat/storage";

@Component({
    selector: "app-business-profile",
    templateUrl: "./business-profile.component.html",
    styleUrls: ["./business-profile.component.sass"],
})
export class BusinessProfileComponent implements OnInit {

    readMore: boolean = true;
    creatingAbout: boolean = false;
    isInvestor: boolean = false;
    user: IUser = new InvestorUserModel();
    aboutForm: FormGroup = new FormGroup({
        about: new FormControl("", [<any>Validators.required]),
    });

    constructor(private http: HttpClient, private cookies: CookieService) {
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
            console.log(this.user);
    }

    readMoreClick() {
        this.readMore = !this.readMore;
        console.log(`Read More > ${this.readMore}`);
    }

    createAbout() {
        this.creatingAbout = !this.creatingAbout;
    }

    onSubmit() {
        let formData = {
            about: this.aboutForm.get("about")?.value,
        };
        this.user.setAbout(formData.about!);
        this.creatingAbout = !this.creatingAbout;

        let body = {
            about: formData.about,
        };
        this.http
            .post("http://102.221.36.216:8081/profile/new", body)
            .subscribe((data) => {
                
            });
    }



}

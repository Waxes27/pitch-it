import {DOCUMENT} from "@angular/common";
import {Component, Inject, Input, OnInit} from "@angular/core";
import {Links} from "../../../models/Links";

@Component({
    selector: "app-membership-card",
    templateUrl: "./membership-card.component.html",
    styleUrls: ["./membership-card.component.sass"],
})
export class MembershipCardComponent implements OnInit {

    resolve() {
        this.package = this.package.toLowerCase()

        if (this.package == "platinum") {
            this.document.location.href = Links.freeTrialPayment
        } else if (this.package == "advanced") {
            this.document.location.href = Links.freeTrialPayment
        } else if (this.package == "investor") {
            this.document.location.href = Links.freeTrialPayment
        } else {
            this.document.location.href = Links.freeTrialPayment
        }
    }

    @Input() perks: string[] = [];
    @Input() price: number = 0;
    @Input() package: string = "";

    constructor(@Inject(DOCUMENT) private document: Document) {
    }

    ngOnInit(): void {
    }


}

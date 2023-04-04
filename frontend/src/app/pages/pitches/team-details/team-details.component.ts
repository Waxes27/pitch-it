import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { FormDataService } from "src/app/services/FormDataService";

@Component({
  selector: "app-team-details",
  templateUrl: "./team-details.component.html",
  styleUrls: ["./team-details.component.sass"],
})
export class TeamDetailsComponent implements OnInit {
  teamForm = new FormGroup({
    title: new FormControl("", [<any>Validators.required]),
    memberAbout: new FormControl("", [<any>Validators.required]),
  });

  constructor(
    private formDataService: FormDataService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  onSubmit() {
    console.log("Clicked");
    
    let data = {
      memberDetails: {
        memberList: [
          {
            memberName: "John Doe",
            memberTitle: this.teamForm.get("title")?.value,
            memberAbout: this.teamForm.get("memberAbout")?.value,
          },
        ],
      },
    };

    this.formDataService.updateData(data);
    console.log(this.formDataService.currentData);
    this.router.navigate(["pitch/new/document-details"]);
  }
}

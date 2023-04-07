import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { UserModel } from "src/app/models/User";

@Component({
  selector: "app-business-profile",
  templateUrl: "./business-profile.component.html",
  styleUrls: ["./business-profile.component.sass"],
})
export class BusinessProfileComponent implements OnInit {
  readMore: boolean = true;
  creatingAbout: boolean = false;
  user: UserModel = new UserModel();
  aboutForm = new FormGroup({
    about: new FormControl("", [<any>Validators.required]),
  });
  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http
      .get<UserModel>("http://localhost:8081/user/a@gmail.com")
      .subscribe((data) => {
        console.log(data);
        
        this.user = data;
      });
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
  }
}

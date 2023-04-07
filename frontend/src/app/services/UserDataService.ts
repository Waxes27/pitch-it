import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";
import { InvestorUserModel } from "../models/InvestorUser";

@Injectable({
  providedIn: "root",
})
export class UserDataService {
  private currentUser: InvestorUserModel = new InvestorUserModel();
  private userData = new BehaviorSubject<InvestorUserModel>(this.currentUser);
  currentData = this.userData.asObservable();


  updateUser(data?: any){
    this.currentUser = new InvestorUserModel(data);
    this.userData.next(this.currentUser)
  }
}

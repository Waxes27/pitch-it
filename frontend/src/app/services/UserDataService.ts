import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";
import { UserModel } from "../models/User";

@Injectable({
  providedIn: "root",
})
export class UserDataService {
  private currentUser: UserModel = new UserModel;
  private userData = new BehaviorSubject<UserModel>(this.currentUser);
  currentData = this.userData.asObservable();

  updateUser(data?: any){
    this.currentUser = new UserModel(data);
  }
}

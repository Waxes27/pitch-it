import {IUser} from "./IUser";

export class InvestorUserModel implements IUser{


  firstName;
  lastName;
   role;
   location;
   about?;
  constructor(data?: any) {
    if (data) {
      this.firstName = data.firstName;
      this.lastName = data.lastName;
      this.role = data.role;
      this.location = "UK";
      this.about = data.about;
    } else {
      this.firstName = "";
      this.lastName = "";
      this.role = "";
      this.location = "";
      this.about = "";
    }
  }


  public setAbout(aboutText?: string) {
    this.about = aboutText;
  }

  getFirstName(): string {
    return this.firstName;
  }

  getLastName(): string{
    return this.lastName;
  }

  getRole(): string {
    return this.role;
  }

  getLocation(): string {
    return this.location;
  }

  getAbout(): string {
    return this.about;
  }
}

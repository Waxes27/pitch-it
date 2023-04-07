export class UserModel {
  private firstName;
  private lastName;
  private title;
  private location;
  private about?;
  constructor(data?: any) {
    if (data) {
      this.firstName = data.firstName;
      this.lastName = data.lastName;
      this.title = data.title;
      this.location = data.location;
      this.about = data.about;
    } else {
      this.firstName = "";
      this.title = "";
      this.location = "";
      this.about = "";
    }
  }

  public setAbout(v?: string) {
    this.about = v;
  }

  getFirstName() {
    return this.firstName;
  }

  getLastName(){
    return this.lastName;
  }

  getTitle() {
    return this.title;
  }

  getLocation() {
    return this.location;
  }

  getAbout() {
    return this.about;
  }
}

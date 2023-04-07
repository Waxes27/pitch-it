export class UserModel {
  private name;
  private title;
  private location;
  private about?;
  constructor(data?: any) {
    if (data) {
      this.name = data.name;
      this.title = data.title;
      this.location = data.location;
      this.about = data.about;
    } else {
      this.name = "";
      this.title = "";
      this.location = "";
      this.about = "";
    }
  }

  
  public setAbout(v?: string) {
    this.about = v;
  }
  

  getName(){
    return this.name;
  }

  getTitle(){
    return this.title;
  }

  getLocation(){
    return this.location;
  }

  getAbout(){
    return this.about;
  }
}

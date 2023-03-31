export class CompanyDetailsRequest {
  name: string;
  registrationNumber: string;
  website: string;
  instagram: string;
  twitter: string;
  facebook: string;
  growthStage: string;
  country: string;
  registeredName: string;
  linkedin: string;
  sector: string;

  constructor(
    name: string,
    registrationNumber: string,
    website: string,
    instagram: string,
    twitter: string,
    facebook: string,
    growthStage: string,
    country: string,
    registeredName: string,
    linkedin: string,
    sector: string
  ) {
    this.name = name;
    (this.registrationNumber = registrationNumber), (this.website = website);
    this.instagram = instagram;
    this.twitter = twitter;
    this.facebook = facebook;
    this.growthStage = growthStage;
    this.country = country;
    this.registeredName = registeredName;
    this.linkedin = linkedin;
    this.sector = sector;
  }
}

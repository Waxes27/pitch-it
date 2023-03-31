export class CompanyDetailsRequest implements ICompanyDetails {
  name: string = "";
  registrationNumber: string = "";
  country: string = "";
  registeredName: string = "";
  sector: string = "";
  businessGrowthStage: string = "";
  socials = {
    website: "",
    instagram: "",
    twitter: "",
    facebook: "",
    linkedin: "",
  };

  constructor(data: ICompanyDetails) {
    Object.assign(this, data);
  }
}

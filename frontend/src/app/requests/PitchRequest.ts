import { CompanyDetailsRequest } from "./CompanyDetailsRequest";

export class PitchRequest {
  companyRequestData: CompanyDetailsRequest;

  constructor(companyRequestData: CompanyDetailsRequest) {
    this.companyRequestData = companyRequestData;
  }
}

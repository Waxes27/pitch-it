import { CompanyDetailsRequest } from "./CompanyDetailsRequest";

export class PitchRequest {
  companyRequest: CompanyDetailsRequest;

  constructor(companyRequest: CompanyDetailsRequest) {
    this.companyRequest = companyRequest;
  }
}

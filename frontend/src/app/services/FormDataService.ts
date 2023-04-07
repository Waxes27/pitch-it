import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class FormDataService {
  private formDataSet: any[] = [];
  private formData = new BehaviorSubject<any[]>(this.formDataSet);
  currentData = this.formData.asObservable();

  constructor() {}

  updateData(data: any) {
    this.formDataSet.push(data);
    this.formData.next(this.formDataSet);
  }

  createObjectFromEntries() {
    const data = this.formDataSet;
    console.log(data);
    

    const companyDetails = {
      name: data[0].companyDetails.name,
      registrationNumber: data[0].companyDetails.registrationNumber,
      country: data[0].companyDetails.country,
      registeredCompanyName: data[0].companyDetails.companyName,
      sector: data[0].companyDetails.sector,
      businessGrowthStage: data[0].companyDetails.growthStage,
      socials: {
        website: data[0].companyDetails.website,
        instagram: data[0].companyDetails.instagram,
        twitter: data[0].companyDetails.twitter,
        facebook: data[0].companyDetails.facebook,
        linkedin: data[0].companyDetails.linkedin,
      },
    };

    const businessDetails = {
      product: data[1].businessDetails.product,
      problemSolved: data[1].businessDetails.problemSolved,
      businessModel: data[1].businessDetails.businessModel,
      reasonForRaising: data[1].businessDetails.raising,
    };

    const marketDetails = {
      marketResearch: data[2].marketDetails.marketResearch,
      keyCompetitors: data[2].marketDetails.advantages,
    }

    const memberDetails = {
      memberList: data[3].memberDetails.memberList
    }

    const documents = {};

    return {
      companyDetails,
      businessDetails,
      marketDetails,
      memberDetails,
      documents,
    };
  }
}

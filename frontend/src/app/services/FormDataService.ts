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
  
    const companyDetails = {
      name: data[0].name,
      registrationNumber: data[0].regNumber,
      country: data[0].country,
      registeredCompanyName: data[0].registeredCompanyName,
      sector: data[0].sector,
      businessGrowthStage: data[0].businessGrowthStage,
      socials: {
        website: data[0].website,
        instagram: data[0].instagram,
        twitter: data[0].twitter,
        facebook: data[0].facebook,
        linkedin: data[0].linkedin
      }
    };
  
    const businessDetails = {
      product: data[1].product,
      problemSolved: data[1].problemSolved,
      businessModel: data[1].businessModel,
      reasonForRaising: data[1].reasonForRaising
    };
  
    const marketDetails = {
      marketResearch: data[2].marketResearch,
      keyCompetitors: data[2].keyCompetitors
    };
  
    const memberDetails = {
      
    };
  
    const documents = data[4];
  
    return {
      companyDetails,
      businessDetails,
      marketDetails,
      memberDetails,
      documents
    };
  }
}

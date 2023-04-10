export class CompanyDetailsModel {
    name:string;
    registrationNumber: number;
    country: string;
    registeredCompanyName: string;
    sector: string;
    businessGrowthStage: string;
    socials: object


    constructor(data: any) {
        this.name = data.name;
        this.registrationNumber = data.registrationNumber;
        this.country = data.country;
        this.registeredCompanyName = data.registeredCompanyName;
        this.sector = data.sector;
        this.businessGrowthStage = data.businessGrowthStage;
        this.socials = data.socials;
    }
}
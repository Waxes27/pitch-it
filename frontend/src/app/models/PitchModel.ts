import {CompanyDetailsModel} from "./CompanyDetailsModel";
import {BusinessDetailsModel} from "./BusinessDetailsModel";
import {MarketDetailsModel} from "./MarketDetailsModel";
import {MemberDetails} from "./MemberDetails";

export class PitchModel {
    private _companyDetails: CompanyDetailsModel;
    private _businessDetails: BusinessDetailsModel;
    private _marketDetails: MarketDetailsModel;
    private _memberDetails: MemberDetails;


    constructor(companyDetails: CompanyDetailsModel, businessDetails: BusinessDetailsModel, marketDetails: MarketDetailsModel, memberDetails: MemberDetails) {
        this._companyDetails = companyDetails;
        this._businessDetails = businessDetails;
        this._marketDetails = marketDetails;
        this._memberDetails = memberDetails;
    }

    get companyDetails(): CompanyDetailsModel {
        return this._companyDetails;
    }

    set companyDetails(value: CompanyDetailsModel) {
        this._companyDetails = value;
    }

    get businessDetails(): BusinessDetailsModel {
        return this._businessDetails;
    }

    set businessDetails(value: BusinessDetailsModel) {
        this._businessDetails = value;
    }

    get marketDetails(): MarketDetailsModel {
        return this._marketDetails;
    }

    set marketDetails(value: MarketDetailsModel) {
        this._marketDetails = value;
    }

    get memberDetails(): MemberDetails {
        return this._memberDetails;
    }

    set memberDetails(value: MemberDetails) {
        this._memberDetails = value;
    }
}
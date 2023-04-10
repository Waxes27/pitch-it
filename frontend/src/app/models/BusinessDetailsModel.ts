export class BusinessDetailsModel {
    private _product: string;
    private _problemSolved: string;
    private _businessModel: string;
    private _reasonForRaising: string;

    constructor(data: { product: string; problemSolved: string; businessModel: string; reasonForRaising: string }) {
        this._product = data.product;
        this._problemSolved = data.problemSolved;
        this._businessModel = data.businessModel;
        this._reasonForRaising = data.reasonForRaising;
    }


    get product(): string {
        return this._product;
    }

    set product(value: string) {
        this._product = value;
    }

    get problemSolved(): string {
        return this._problemSolved;
    }

    set problemSolved(value: string) {
        this._problemSolved = value;
    }

    get businessModel(): string {
        return this._businessModel;
    }

    set businessModel(value: string) {
        this._businessModel = value;
    }

    get reasonForRaising(): string {
        return this._reasonForRaising;
    }

    set reasonForRaising(value: string) {
        this._reasonForRaising = value;
    }
}
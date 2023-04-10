export class MarketDetailsModel {
    private _marketResearch: string;
    private _keyCompetitors: string;

    constructor(data: { marketResearch: string; keyCompetitors: string }) {
        this._marketResearch = data.marketResearch;
        this._keyCompetitors = data.keyCompetitors;
    }

    get marketResearch(): string {
        return this._marketResearch;
    }

    set marketResearch(value: string) {
        this._marketResearch = value;
    }

    get keyCompetitors(): string {
        return this._keyCompetitors;
    }

    set keyCompetitors(value: string) {
        this._keyCompetitors = value;
    }

}
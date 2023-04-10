export class MemberModel {
    private _memberName: string;
    private _memberTitle: string;
    private _memberAbout: string;

    constructor(data: { memberName: string, memberTitle: string, memberAbout: string }) {
        this._memberName = data.memberName;
        this._memberTitle = data.memberTitle;
        this._memberAbout = data.memberAbout;
    }


    get memberName(): string {
        return this._memberName;
    }

    set memberName(value: string) {
        this._memberName = value;
    }

    get memberTitle(): string {
        return this._memberTitle;
    }

    set memberTitle(value: string) {
        this._memberTitle = value;
    }

    get memberAbout(): string {
        return this._memberAbout;
    }

    set memberAbout(value: string) {
        this._memberAbout = value;
    }
}
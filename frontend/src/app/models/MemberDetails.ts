import {MemberModel} from "./MemberModel";

export class MemberDetails {
    private _memberList: MemberModel[];


    constructor(memberList: MemberModel[]) {
        this._memberList = memberList;
    }


    get memberList(): MemberModel[] {
        return this._memberList;
    }

    set memberList(value: MemberModel[]) {
        this._memberList = value;
    }
}
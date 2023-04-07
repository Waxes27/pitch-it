import {IUser} from "./IUser";

export class BusinessUserModel implements IUser{
    firstName:string
    lastName: string;
    location: string;
    about?: string;
    role: string

    constructor(data?: any) {
        this.lastName = data.representativeFirstName;
        this.firstName = data.representativeLastName;
        this.role = data.role;
        this.location = "UK";
        this.about = data.about;
    }

    getRole(): string {
        return this.role;
    }

    public setAbout(aboutText?: string) {
        this.about = aboutText;
    }

    getAbout(): string {
        return this.about!;
    }

    getFirstName(): string {
        return this.role;
    }

    getLastName(): string {
        return this.lastName;
    }

    getLocation(): string {
        return this.location;
    }


}
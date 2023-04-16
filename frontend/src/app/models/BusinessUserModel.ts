import {IUser} from "../interfaces/IUser";

export class BusinessUserModel implements IUser {
    id: number | null;
    firstName: string;
    lastName: string;
    location: string;
    about?: string;
    role: string

    constructor(data?: any) {
        this.id = data.id
        this.lastName = data.representativeLastName;
        this.firstName = data.representativeFirstName;
        this.role = data.role;
        this.location = "UK";
        this.about = data.about;
    }

    setPicture(pictureUrl: string): void {
        throw new Error("Method not implemented.");
    }

    getId(): number | null {
        return this.id
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
        return this.firstName;
    }

    getLastName(): string {
        return this.lastName;
    }

    getLocation(): string {
        return this.location;
    }


}
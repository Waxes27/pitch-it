export interface IUser{
    firstName:string;
    lastName:string;
    role: string;
    about?: string

    getFirstName():string
    getLastName():string
    getLocation():string
    getRole():string
    getAbout():string
    setAbout(about: string):void

}
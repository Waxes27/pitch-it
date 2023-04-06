export class User {
    private name;
    private title;
    private location;
    constructor(data: any) {
        this.name = data.name
        this.title = data.title
        this.location = data.location
    }
}
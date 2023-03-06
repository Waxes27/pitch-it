export class Patient {
    constructor(private id: String,private name: String){}

    getName(){
        return this.name;
    }

    getId(){
        return this.id;
    }
  }
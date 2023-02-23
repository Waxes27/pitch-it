import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-team-details',
  templateUrl: './team-details.component.html',
  styleUrls: ['./team-details.component.sass']
})

export class TeamDetailsComponent implements OnInit {

  

  
  members: Members[] = [
    {
      name: "John Doe",
      role: "CEO",
      about:" Lorem Ipsum?"
    }
  ];

  selected : number = 3;
  numbers = Array(this.selected).fill(this.selected).map((x,i)=>i);


  teamForm = new FormGroup({
    name: new FormControl('',[<any>Validators.required]),
    surname: new FormControl('', [<any>Validators.required]),
    DOB: new FormControl('', [<any>Validators.required, Validators.pattern("")]),
    username: new FormControl('', [<any>Validators.required, <any>Validators.minLength(6)]),
    password: new FormControl('', [<any>Validators.required, <any>Validators.minLength(8)]),
    role: new FormControl('')
  });

  


  constructor() { 
    
  }

  ngOnInit(): void {
  }

  

  changeSelected(){
    console.log(this.selected)
    
    this.numbers = Array(this.selected).fill(this.selected).map((x,i)=>i)
    console.log(this.numbers)
    
  }

}

interface Members {
  name: string;
  role: string;
  about: string;
}

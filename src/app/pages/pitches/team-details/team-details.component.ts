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

  selected : number = 0;


  teamForm = new FormGroup({
    name: new FormControl('',[<any>Validators.required]),
    surname: new FormControl('', [<any>Validators.required]),
    DOB: new FormControl('', [<any>Validators.required, Validators.pattern("")]),
    username: new FormControl('', [<any>Validators.required, <any>Validators.minLength(6)]),
    password: new FormControl('', [<any>Validators.required, <any>Validators.minLength(8)]),
    role: new FormControl('')
  });


  constructor() { }

  ngOnInit(): void {
  }

}

interface Members {
  name: string;
  role: string;
  about: string;
}

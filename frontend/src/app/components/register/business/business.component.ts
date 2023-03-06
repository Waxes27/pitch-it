import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-business',
  templateUrl: './business.component.html',
  styleUrls: ['./business.component.sass']
})
export class BusinessComponent implements OnInit {

  constructor(private http : HttpClient, private auth : AuthService) { }

  ngOnInit(): void {
  }

  roles = [
    "Investor",
    "Business",
  ]
  

  registrationForm = new FormGroup({
    name: new FormControl('',[<any>Validators.required]),
    surname: new FormControl('', [<any>Validators.required]),
    DOB: new FormControl('', [<any>Validators.required, Validators.pattern("")]),
    username: new FormControl('', [<any>Validators.required, <any>Validators.minLength(6)]),
    password: new FormControl('', [<any>Validators.required, <any>Validators.minLength(8)]),
    role: new FormControl('')
  });
  


  onSubmit(){

    // if (this.registrationForm.valid){
      var formData: any = new FormData();
      formData.append('name', this.registrationForm.get('name')?.value)
      formData.append('surname', this.registrationForm.get('surname')?.value)
      formData.append('DOB',this.registrationForm.get('DOB')?.value)
      formData.append('username',this.registrationForm.get('username')?.value)
      formData.append('password',this.registrationForm.get('password')?.value)
      formData.append('role',"Investor")
  
      for (var i of formData){
        console.log(i);
        
      }
      
      // this.http.post("http://localhost:8080/registration",formData).subscribe()
  
      this.auth.registerBusiness(formData)
      
    }
    

    

  // }

}
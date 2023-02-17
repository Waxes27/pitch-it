import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-main-component',
  templateUrl: './main-component.component.html',
  styleUrls: ['./main-component.component.sass']
})
export class MainComponentComponent implements OnInit {
  constructor(public auth: AuthService,private router: Router) {
    
  }
  routesList = ["/","/questionaire","/login","/register/investor","/preferences/investor",]
  checkRoute(){
    
    for (var key in this.routesList) {
      console.log(this.routesList[key]);
      
      if (this.router.url == this.routesList[key]){
        console.log("true and equal");
        
        return true
      }
    }
    return false
  }

  ngOnInit(): void {
  }

}

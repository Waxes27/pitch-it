import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-main-component',
  templateUrl: './main-component.component.html',
  styleUrls: ['./main-component.component.sass']
})
export class MainComponentComponent implements OnInit {
  constructor(public auth: AuthService) {
    
  }
  

  ngOnInit(): void {
  }

}

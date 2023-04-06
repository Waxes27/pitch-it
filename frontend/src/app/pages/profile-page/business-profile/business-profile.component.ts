import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-business-profile',
  templateUrl: './business-profile.component.html',
  styleUrls: ['./business-profile.component.sass']
})
export class BusinessProfileComponent implements OnInit {
  readMore: boolean = true;
  constructor() { }

  ngOnInit(): void {
  }

  readMoreClick(){
    this.readMore = !this.readMore;
    console.log(`Read More > ${this.readMore}`);
    
  }

}

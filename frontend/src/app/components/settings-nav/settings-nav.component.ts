import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-settings-nav',
  templateUrl: './settings-nav.component.html',
  styleUrls: ['./settings-nav.component.sass']
})
export class SettingsNavComponent implements OnInit {
  currentView: string = '';

  views:string[] = ['accountInformation', 'notifications', 'billing', 'privacy', 'contact']
  constructor() { }

  ngOnInit(): void {
  }

  changeView(view: string){
    if(view && this.views.indexOf(view)){
      this.currentView = view
    }
  }

}

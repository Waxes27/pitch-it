import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.sass']
})
export class SettingsComponent implements OnInit {
  @Input() currentView:string = 'accountInformation';
  constructor() { }

  ngOnInit(): void {
  }

}

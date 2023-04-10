import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-pitch',
  templateUrl: './pitch.component.html',
  styleUrls: ['./pitch.component.sass']
})
export class PitchComponent implements OnInit {
  @Input() title:string = '';
  @Input() body:string = '';

  constructor() { }

  ngOnInit(): void {
  }

}

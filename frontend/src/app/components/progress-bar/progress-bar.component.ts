import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-progress-bar',
  templateUrl: './progress-bar.component.html',
  styleUrls: ['./progress-bar.component.sass']
})
export class ProgressBarComponent implements OnInit {

  @Input() targetAmount: number = 0;
  @Input() currentAmount: number = 0;
  @Input() barWidth: number = 0;

  percentComplete: number = 0;


  constructor() { }

  ngOnInit(): void {
    this.percentComplete = (this.currentAmount / this.targetAmount) * 100;
  }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-investor-splash',
  templateUrl: './investor-splash.component.html',
  styleUrls: ['./investor-splash.component.sass']
})
export class InvestorSplashComponent implements OnInit {

  constructor(private router: Router) { }

  async ngOnInit(): Promise<void> {
    await new Promise(f => setTimeout(f, 2500));
    this.router.navigate(["/home"])

  }

}

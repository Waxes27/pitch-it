import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthService } from './auth/auth.service'
import { AuthGuard } from './auth/auth.guard'

import { BrowserModule } from '@angular/platform-browser';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { InvestorDashboardComponent } from './components/dashboard/investor-dashboard/investor-dashboard.component';
import { QuestionaireComponentComponent } from './components/questionaire-component/questionaire-component.component';
import { InvestorComponent } from './components/register/investor/investor.component';
import { BusinessComponent } from './components/register/business/business.component';
import { InvestorPreferencesComponentComponent } from './components/preferences/investor-preferences-component/investor-preferences-component.component';
import { BusinessPreferencesComponentComponent } from './components/preferences/business-preferences-component/business-preferences-component.component';

const routes: Routes = [
  {path: "login", title: "Login",component: LoginComponent},
  {path: "home", title: "Welcome Home",component: HomeComponent},
  {path: "investor-dashboard", title: "Investor Dashboard",component: InvestorDashboardComponent},
  {path: "questionaire", title: "Sign up as...",component: QuestionaireComponentComponent},
  {path: "preferences/investor", title: "Sign up as...",component: InvestorPreferencesComponentComponent},
  {path: "preferences/business", title: "Sign up as...",component: BusinessPreferencesComponentComponent},
  // {path: "InvestorComponent", title: "Patient Dash",component: PatientDashComponent, canActivate: [AuthGuard]},
  {path: "register/investor", title: "Register as an Investor",component: InvestorComponent},
  {path: "register/business", title: "Register as a Business",component: BusinessComponent},
];


@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule
  ],
  providers: [AuthService, AuthGuard],
  exports: [RouterModule]
})
export class AppRoutingModule { }

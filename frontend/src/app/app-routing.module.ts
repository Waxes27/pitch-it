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
import { DetailsPageComponent } from './components/details-page/details-page.component';
import { PitchesComponent } from './pages/pitches/pitches.component';
import { PitchQuestionnaireComponent } from './pages/pitches/pitch-questionnaire/pitch-questionnaire.component';
import { CompanyDetailsComponent } from './pages/pitches/company-details/company-details.component';
import { BusinessDetailsComponent } from './pages/pitches/business-details/business-details.component';
import { MarketDetailsComponent } from './pages/pitches/market-details/market-details.component';
import { TeamDetailsComponent } from './pages/pitches/team-details/team-details.component';
import { LandingPageComponent } from './pages/landing-page/landing-page.component';
import { InvestorMembershipComponentsComponent } from './components/membership-components/investor/membership-components.component';
import { CompanyMembershipComponentsComponent } from './components/membership-components/company/membership-components.component';
import { DocumentDetailsComponent } from './pages/pitches/document-details/document-details.component';
import { PaymentPageComponent } from './pages/pitches/payment-page-company/payment-page.component';
import { RegisterComponent } from './pages/register/register.component';


const routes: Routes = [
  {path: "", title: "Welcome",component: LandingPageComponent},
  {path: "login", title: "Login",component: LoginComponent},
  {path: "home", title: "Welcome Home",component: HomeComponent},
  {path: "investor-dashboard", title: "Investor Dashboard",component: InvestorDashboardComponent},
  {path: "questionaire", title: "Sign up as...",component: QuestionaireComponentComponent},

  {path: "preferences/investor", title: "Sign up as...",component: InvestorPreferencesComponentComponent},
  {path: "preferences/business", title: "Sign up as...",component: BusinessPreferencesComponentComponent},

  {path: "register", title: "Register as an Investor",component: RegisterComponent},
  {path: "register/investor", title: "Register as an Investor",component: InvestorComponent},
  {path: "register/business", title: "Register as a Business",component: BusinessComponent},

  {path: "details", title:"Details", component: DetailsPageComponent},

  {path: "pitch/new", title: "Patient Dash",component: PitchesComponent},
  {path: "pitch/new/questionnaire", title: "Patient Dash",component: PitchQuestionnaireComponent},
  {path: "pitch/new/company-details", title: "Patient Dash",component: CompanyDetailsComponent},
  {path: "pitch/new/business-details", title: "Patient Dash",component: BusinessDetailsComponent},
  {path: "pitch/new/market-details", title: "Patient Dash",component: MarketDetailsComponent},
  {path: "pitch/new/team-details", title: "Patient Dash",component: TeamDetailsComponent},
  {path: "pitch/new/document-details", title: "Patient Dash",component: DocumentDetailsComponent},

  {path: "membership/investor", title: "Patient Dash",component: InvestorMembershipComponentsComponent},
  {path: "membership/company", title: "Patient Dash",component: CompanyMembershipComponentsComponent},

  {path: "payment", title: "Patient Dash",component: PaymentPageComponent},



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

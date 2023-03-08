import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { NgCreditCardModule } from "angular-credit-card";
import { MatStepperModule } from "@angular/material/stepper";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { MatInputModule } from "@angular/material/input";
import { MatSelectModule } from "@angular/material/select";
import { MatToolbarModule } from "@angular/material/toolbar";
import { MatIconModule } from "@angular/material/icon";
import { MatSidenavModule } from "@angular/material/sidenav";
import { MatCardModule } from "@angular/material/card";
import { MatDatepickerModule } from "@angular/material/datepicker";
import { MatButtonModule } from "@angular/material/button";
import { HttpClientModule } from "@angular/common/http";
import { MatNativeDateModule } from "@angular/material/core";
import { LoginComponent } from "./components/login/login.component";
import { MatExpansionModule } from "@angular/material/expansion";
import { MainComponentComponent } from "./components/main-component/main-component.component";
import { HeaderComponentComponent } from "./components/header-component/header-component.component";
import { HomeComponent } from "./components/home/home.component";
import { InvestorDashboardComponent } from "./components/dashboard/investor-dashboard/investor-dashboard.component";
import { InvestorComponent } from "./components/register/investor/investor.component";
import { QuestionaireComponentComponent } from "./components/questionaire-component/questionaire-component.component";
import { BusinessComponent } from "./components/register/business/business.component";
import { InvestorPreferencesComponentComponent } from "./components/preferences/investor-preferences-component/investor-preferences-component.component";
import { BusinessPreferencesComponentComponent } from "./components/preferences/business-preferences-component/business-preferences-component.component";
import { MatTooltipModule } from "@angular/material/tooltip";
import { MatSlideToggleModule } from "@angular/material/slide-toggle";
import { MatGridListModule } from "@angular/material/grid-list";
import { DetailsPageComponent } from "./components/details-page/details-page.component";
import { PitchesComponent } from "./pages/pitches/pitches.component";
import { CompanyDetailsComponent } from "./pages/pitches/company-details/company-details.component";
import { PitchQuestionnaireComponent } from "./pages/pitches/pitch-questionnaire/pitch-questionnaire.component";
// import { TextBoxModule, NumericTextBoxModule, MaskedTextBoxModule, SliderModule, UploaderModule, ColorPickerModule, SignatureModule, RatingModule } from '@syncfusion/ej2-angular-inputs';
import { MarketDetailsComponent } from "./pages/pitches/market-details/market-details.component";
import { BusinessDetailsComponent } from "./pages/pitches/business-details/business-details.component";
import { TeamDetailsComponent } from './pages/pitches/team-details/team-details.component';
import { LandingPageComponent } from './pages/landing-page/landing-page.component';
import { InvestorMembershipComponentsComponent } from "./components/membership-components/investor/membership-components.component";
import { CompanyMembershipComponentsComponent } from "./components/membership-components/company/membership-components.component";
import { DocumentDetailsComponent } from './pages/pitches/document-details/document-details.component';
import { PaymentPageComponent } from './pages/pitches/payment-page-company/payment-page.component';
import { RegisterComponent } from './pages/register/register.component';
import { InvestorSplashComponent } from './pages/splash-pages/investor-splash/investor-splash.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MainComponentComponent,
    HeaderComponentComponent,
    HomeComponent,
    InvestorDashboardComponent,
    InvestorComponent,
    QuestionaireComponentComponent,
    BusinessComponent,
    InvestorPreferencesComponentComponent,
    BusinessPreferencesComponentComponent,
    DetailsPageComponent,
    PitchesComponent,
    CompanyDetailsComponent,
    PitchQuestionnaireComponent,
    MarketDetailsComponent,
    BusinessDetailsComponent,
    TeamDetailsComponent,
    LandingPageComponent,
    InvestorMembershipComponentsComponent,
    CompanyMembershipComponentsComponent,
    DocumentDetailsComponent,
    PaymentPageComponent,
    RegisterComponent,
    InvestorSplashComponent
  ],
  imports: [
    MatStepperModule,
    NgCreditCardModule,
    MatGridListModule,
    MatSlideToggleModule,
    MatTooltipModule,
    MatNativeDateModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    HttpClientModule,
    MatToolbarModule,
    MatIconModule,
    MatSidenavModule,
    MatCardModule,
    MatDatepickerModule,
    MatExpansionModule,
    // TextBoxModule, NumericTextBoxModule, MaskedTextBoxModule, SliderModule, UploaderModule, ColorPickerModule, SignatureModule, RatingModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}

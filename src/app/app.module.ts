import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatInputModule} from '@angular/material/input'
import {MatSelectModule} from '@angular/material/select'
import {MatToolbarModule} from '@angular/material/toolbar'
import {MatIconModule} from '@angular/material/icon'
import {MatSidenavModule} from '@angular/material/sidenav'
import {MatCardModule} from '@angular/material/card'
import {MatDatepickerModule} from '@angular/material/datepicker'
import {MatButtonModule} from '@angular/material/button'
import { HttpClientModule } from '@angular/common/http';
import {MatNativeDateModule} from '@angular/material/core';
import { LoginComponent } from './components/login/login.component';
import {MatExpansionModule} from '@angular/material/expansion';
import { MainComponentComponent } from './components/main-component/main-component.component';
import { HeaderComponentComponent } from './components/header-component/header-component.component';
import { HomeComponent } from './components/home/home.component';
import { InvestorDashboardComponent } from './components/dashboard/investor-dashboard/investor-dashboard.component';
import { InvestorComponent } from './components/register/investor/investor.component';
import { QuestionaireComponentComponent } from './components/questionaire-component/questionaire-component.component';
import { BusinessComponent } from './components/register/business/business.component';
import { InvestorPreferencesComponentComponent } from './components/preferences/investor-preferences-component/investor-preferences-component.component';
import { BusinessPreferencesComponentComponent } from './components/preferences/business-preferences-component/business-preferences-component.component';
import {MatTooltipModule} from '@angular/material/tooltip'
import {MatSlideToggleModule} from '@angular/material/slide-toggle'
import {MatGridListModule} from '@angular/material/grid-list'


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
  ],
  imports: [
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
    MatExpansionModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }



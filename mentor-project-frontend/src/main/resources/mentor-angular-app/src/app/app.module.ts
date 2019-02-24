import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClient, HttpHandler, HttpClientModule } from '@angular/common/http';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { TrainingsListComponent } from './trainings-list/trainings-list.component';
import {MatNativeDateModule} from "@angular/material";
import {AngularMaterialModule} from "./angular-material/angular-material.module";
import { HomepageComponent } from './homepage/homepage.component';
import { UsersListComponent } from './users-list/users-list.component';
import { LoginComponent } from './login/login.component';
import {JwtInterceptor} from './_helper/jwt.interceptor';
import {ErrorInterceptor} from "./_helper/error.interceptor";
import {fakeBackendProvider} from "./_helper/fake-backend";
import {AuthGuard} from "./_guards/auth.guard";

const appRoutes: Routes = [
  {
    path: '',
    component: UsersListComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'signup',
    component: SignupComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'trainings-list',
    component: TrainingsListComponent,
    canActivate: [AuthGuard]
  },
  {
    path: '**', redirectTo: ''
  }
];

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    TrainingsListComponent,
    HomepageComponent,
    UsersListComponent,
    LoginComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: false } // <-- debugging purposes only
    ),
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    AngularMaterialModule,
    BrowserAnimationsModule,
    MatNativeDateModule,
  ],
  providers: [
    HttpClient,
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },

    // provider used to create fake backend
    fakeBackendProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

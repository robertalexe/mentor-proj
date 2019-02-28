import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupUserComponent } from './signup-user/signup-user.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClient, HttpHandler, HttpClientModule } from '@angular/common/http';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {
  DialogOverviewExampleDialog,
  SnackbarProposalComponent,
  TrainingsListComponent
} from './trainings-list/trainings-list.component';
import {MatDialogModule, MatNativeDateModule} from "@angular/material";
import {AngularMaterialModule} from "./angular-material/angular-material.module";
import { HomepageComponent } from './homepage/homepage.component';
import { UsersListComponent } from './users-list/users-list.component';
import { LoginComponent } from './login/login.component';
import {JwtInterceptor} from './_helper/jwt.interceptor';
import {ErrorInterceptor} from "./_helper/error.interceptor";
import {AuthGuard} from "./_guards/auth.guard";
import { UserHomepageComponent } from './user-homepage/user-homepage.component';
import { MentorHomepageComponent } from './mentor-homepage/mentor-homepage.component';
import {RoleGuard} from "./_guards/role.guard";
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { UserActiveTrainingsComponent } from './user-active-trainings/user-active-trainings.component';
import { MentorProposalsComponent } from './mentor-proposals/mentor-proposals.component';
import { MentorDetailsComponent } from './mentor-details/mentor-details.component';
import { AdminHomepageComponent } from './admin-homepage/admin-homepage.component';
import { TechnologiesListComponent } from './technologies-list/technologies-list.component';
import { SignupMentorComponent } from './signup-mentor/signup-mentor.component';

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
    path: 'signup-user',
    component: SignupUserComponent
  },
  {
    path: 'signup-mentor',
    component: SignupMentorComponent
  },
  {
    path: 'user-homepage',
    component: UserHomepageComponent,
    canActivate: [AuthGuard, RoleGuard]
  },
  {
    path: 'mentor-homepage',
    component: MentorHomepageComponent,
    canActivate: [AuthGuard, RoleGuard]
  },
  {
    path: 'admin-homepage',
    component: AdminHomepageComponent,
    canActivate: [AuthGuard, RoleGuard]
  },
  {
    path: 'forbidden',
    component: ForbiddenComponent
  },
  {
    path: '**', redirectTo: ''
  }
];

@NgModule({
  declarations: [
    AppComponent,
    SignupUserComponent,
    TrainingsListComponent,
    DialogOverviewExampleDialog,
    HomepageComponent,
    UsersListComponent,
    LoginComponent,
    UserHomepageComponent,
    MentorHomepageComponent,
    ForbiddenComponent,
    UserActiveTrainingsComponent,
    MentorProposalsComponent,
    SnackbarProposalComponent,
    MentorDetailsComponent,
    AdminHomepageComponent,
    TechnologiesListComponent,
    SignupMentorComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: false } // <-- debugging purposes only
    ),
    BrowserModule,
    //AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    AngularMaterialModule,
    BrowserAnimationsModule,
    MatNativeDateModule,
    MatDialogModule,
  ],
  entryComponents: [
    DialogOverviewExampleDialog,
    SnackbarProposalComponent
  ],
  providers: [
    HttpClient,
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

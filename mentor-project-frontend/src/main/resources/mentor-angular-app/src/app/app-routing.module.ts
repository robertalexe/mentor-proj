import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupUserComponent } from './signup-user/signup-user.component';

const routes: Routes = [
  {
    //path: 'signup-user', component: SignupUserComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

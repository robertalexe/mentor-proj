import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { User } from '../shared/models/user.model';
import { UserForm } from '../shared/models/user-form';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  userForm: FormGroup;
  user: User;

  constructor(
    private http: HttpClient
  ) { 
    this.userForm = new UserForm();
  }

  ngOnInit() {
  }

  onSignUpUser() {
    if(this.userForm.valid) {
      this.user = new User();
      this.user.id = this.userForm.value.email;
      this.user.userName = this.userForm.value.username;
      this.user.password = this.userForm.value.password;
      this.user.contactNumber = this.userForm.value.contactNo;
      this.user.firstName = this.userForm.value.firstName;
      this.user.lastName = this.userForm.value.lastName;
      this.http.post('http://localhost:8080/api/user', this.user).subscribe( (response) => {
        console.log(response);
      });
    }
  }

}

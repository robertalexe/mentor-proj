import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
  }

  navigateToSignUp() {
    this.router.navigateByUrl('/signup-user');
  }

  navigateToTrainingsList() {
    this.router.navigateByUrl('/trainings-list');
  }

}

import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

export interface Mentor {
  email: string,
  firstName: string,
  lastName: string,
  contactNumber: string,
  timeZone: string,
  technologiesList: string,
  linkedInUrl: string,
  yearsOfExperience: number
}


@Component({
  selector: 'app-mentor-details',
  templateUrl: './mentor-details.component.html',
  styleUrls: ['./mentor-details.component.css']
})
export class MentorDetailsComponent implements OnInit {

  private mentorDetails: Mentor;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get<Mentor>('http://localhost:8080/api/mentor/mentor-details').subscribe(
      elem => { this.mentorDetails = elem }
    )
  }

}

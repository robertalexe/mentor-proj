import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormGroup} from "@angular/forms";
import {MentorForm} from "../shared/models/mentor-form";
import {Technology} from "../technologies-list/technologies-list.component";
import {DailyInterval, Mentor, Weekdays} from "../shared/models/mentor.model";

@Component({
  selector: 'app-signup-mentor',
  templateUrl: './signup-mentor.component.html',
  styleUrls: ['./signup-mentor.component.css']
})
export class SignupMentorComponent implements OnInit {

  timezonesArray: string[];
  technologiesArray: Technology[];
  mentorForm: FormGroup;
  mentor: Mentor;

  ngOnInit() {
    this.http.get<string[]>('/ui/api/timezones/all').subscribe( (elem) => {
      this.timezonesArray = elem;
    });
    this.http.get<Technology[]>('/ui/api/technologies/all').subscribe( (elem) => {
      this.technologiesArray = elem;
    });
  }

  constructor(private http: HttpClient) {
    this.mentorForm = new MentorForm();
  }

  signUpMentor() {
    if(this.mentorForm.valid) {
      this.mentor = new Mentor();
      this.mentor.email = this.mentorForm.value.email;
      this.mentor.password = this.mentorForm.value.password;
      this.mentor.contactNumber = this.mentorForm.value.contactNo;
      this.mentor.firstName = this.mentorForm.value.firstName;
      this.mentor.lastName = this.mentorForm.value.lastName;
      this.mentor.timezone = this.mentorForm.value.timezone;
      this.mentor.technologies = this.mentorForm.value.technologies;
      this.mentor.linkedinUrl = this.mentorForm.value.linkedinUrl;
      this.mentor.yearsOfExperience = this.mentorForm.value.yearsOfExperience;
      this.mentor.dailyIntervalTimesMap = new Map<Weekdays, DailyInterval>();
      this.mentor.dailyIntervalTimesMap.set(Weekdays.MONDAY, new DailyInterval(this.mentorForm.value.startTimeMonday, this.mentorForm.value.endTimeMonday));
      this.mentor.dailyIntervalTimesMap.set(Weekdays.TUESDAY, new DailyInterval(this.mentorForm.value.startTimeTuesday, this.mentorForm.value.endTimeTuesday));
      this.mentor.dailyIntervalTimesMap.set(Weekdays.WEDNESDAY, new DailyInterval(this.mentorForm.value.startTimeWednesday, this.mentorForm.value.endTimeWednesday));
      this.mentor.dailyIntervalTimesMap.set(Weekdays.THURSDAY, new DailyInterval(this.mentorForm.value.startTimeThursday, this.mentorForm.value.endTimeThursday));
      this.mentor.dailyIntervalTimesMap.set(Weekdays.FRIDAY, new DailyInterval(this.mentorForm.value.startTimeFriday, this.mentorForm.value.endTimeFriday));
      this.mentor.dailyIntervalTimes = {};
      this.mentor.dailyIntervalTimesMap.forEach((val: DailyInterval, key: Weekdays) => {
        this.mentor.dailyIntervalTimes[key] = val;
      });
      console.log(this.mentorForm);
      console.log(this.mentor);
      this.http.post('/ui/api/mentor', this.mentor).subscribe( (response) => {
        console.log(response);
      });
    }
  }

}

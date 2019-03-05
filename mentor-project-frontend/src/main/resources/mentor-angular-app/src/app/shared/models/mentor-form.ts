import {FormControl, FormGroup} from "@angular/forms";
import {Mentor, Weekdays} from "./mentor.model";

export class MentorForm extends FormGroup {

  constructor(mentor?: Mentor) {
    super( {
        email: new FormControl(mentor? mentor.email : ''),
        contactNo: new FormControl(mentor? mentor.contactNumber:  ''),
        password: new FormControl(mentor? mentor.password : ''),
        firstName: new FormControl(mentor? mentor.firstName : ''),
        lastName: new FormControl(mentor? mentor.lastName : ''),
        timezone: new FormControl(mentor? mentor.timezone : ''),
        technologies: new FormControl(mentor? mentor.technologies : new Array()),
        linkedinUrl: new FormControl(mentor? mentor.linkedinUrl : ''),
        yearsOfExperience: new FormControl(mentor? mentor.yearsOfExperience : ''),
        startTimeMonday: new FormControl(mentor? mentor.dailyIntervalTimesMap.get(Weekdays.MONDAY).startTime : ''),
        endTimeMonday: new FormControl(mentor? mentor.dailyIntervalTimesMap.get(Weekdays.MONDAY).endTime : ''),
        startTimeTuesday: new FormControl(mentor? mentor.dailyIntervalTimesMap.get(Weekdays.TUESDAY).startTime : ''),
        endTimeTuesday: new FormControl(mentor? mentor.dailyIntervalTimesMap.get(Weekdays.TUESDAY).endTime : ''),
        startTimeWednesday: new FormControl(mentor? mentor.dailyIntervalTimesMap.get(Weekdays.WEDNESDAY).startTime : ''),
        endTimeWednesday: new FormControl(mentor? mentor.dailyIntervalTimesMap.get(Weekdays.WEDNESDAY).endTime : ''),
        startTimeThursday: new FormControl(mentor? mentor.dailyIntervalTimesMap.get(Weekdays.THURSDAY).startTime : ''),
        endTimeThursday: new FormControl(mentor? mentor.dailyIntervalTimesMap.get(Weekdays.THURSDAY).endTime : ''),
        startTimeFriday: new FormControl(mentor? mentor.dailyIntervalTimesMap.get(Weekdays.FRIDAY).startTime : ''),
        endTimeFriday: new FormControl(mentor? mentor.dailyIntervalTimesMap.get(Weekdays.FRIDAY).endTime : ''),
      }
    );
  }
}

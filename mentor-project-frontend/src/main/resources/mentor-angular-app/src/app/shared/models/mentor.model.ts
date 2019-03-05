export class Mentor {
  email: string;
  password: string;
  firstName: string;
  lastName: string;
  contactNumber: string;
  timezone: string;
  technologies: string[];
  linkedinUrl: string;
  yearsOfExperience: number;
  dailyIntervalTimesMap: Map<Weekdays, DailyInterval>;
  dailyIntervalTimes: any;
}

export enum Weekdays {
  MONDAY = "MONDAY",
  TUESDAY = "TUESDAY",
  WEDNESDAY = "WEDNESDAY",
  THURSDAY = "THURSDAY",
  FRIDAY = "FRIDAY"
}

export class DailyInterval {
  startTime: string;
  endTime: string;

  constructor(startTime: string, endTime: string) {
    this.startTime = startTime;
    this.endTime = endTime;

  }

}

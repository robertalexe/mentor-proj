import {Component, Inject, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MAT_DIALOG_DATA, MatDialogRef, MatSnackBar} from "@angular/material";
import {DialogData, SnackbarProposalComponent} from "../trainings-list/trainings-list.component";

export class MentorProposedTraining {
  userEmail: string;
  trainingName: string;
}

@Component({
  selector: 'app-mentor-proposals',
  templateUrl: './mentor-proposals.component.html',
  styleUrls: ['./mentor-proposals.component.css']
})
export class MentorProposalsComponent implements OnInit {

  trainingProposals: MentorProposedTraining[];

  constructor(private http: HttpClient, private snackbar: MatSnackBar) { }

  ngOnInit() {
    this.http.get<MentorProposedTraining[]>('http://localhost:8080/api/training/mentor-proposed').subscribe( (resp) => {
      this.trainingProposals = resp;
    });
  }

  public acceptTraining(elem: MentorProposedTraining) {
    this.http.post('http://localhost:8080/api/training/accept-training', elem).subscribe( (resp) => {
      this.snackbar.openFromComponent(CourseAcceptedComponent, {
        duration: 3000,
      });
    })
  }

}

@Component({
  selector: 'course-accepted',
  templateUrl: 'course-accepted.html',
  styles: [`
    .course-accepted {
      color: hotpink;
    }
  `],
})
export class CourseAcceptedComponent {}

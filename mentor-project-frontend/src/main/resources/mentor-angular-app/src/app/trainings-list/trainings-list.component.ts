import {Component, Inject, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {
  MAT_DIALOG_DATA,
  MatDialog,
  MatDialogRef,
  MatPaginator,
  MatSnackBar,
  MatSort,
  MatTableDataSource
} from "@angular/material";

export interface TrainingElement {
  mentorEmail: string;
  mentorFullName: string;
  technologiesList: string;
  yearsOfExperience: number;
  trainingName: string;
  trainingCost: string;
  enrolledUsers: string;
}

export interface DialogData {
  animal: string;
  name: string;
}

export class TrainingProposal {
  trainingName: string;
}

@Component({
  selector: 'app-trainings-list',
  templateUrl: './trainings-list.component.html',
  styleUrls: ['./trainings-list.component.css']
})
export class TrainingsListComponent implements OnInit {

  displayedColumns: string[] = ['mentor-name', 'technologies', 'training-name', 'training-cost', 'propose', 'showDetails'];
  trainingsArray: MatTableDataSource<TrainingElement>;
  trainingProposal: TrainingProposal;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private http: HttpClient, private dialog: MatDialog, private snackbar: MatSnackBar) { }

  ngOnInit() {
    this.http.get<TrainingElement[]>('http://localhost:8080/api/mentors-trainings').subscribe( (elem) => {
      this.trainingsArray = new MatTableDataSource(elem);
      this.trainingsArray.paginator = this.paginator;
      this.trainingsArray.sort = this.sort;
    })
  }

  applyFilter(filterValue: string) {
    this.trainingsArray.filter = filterValue.trim().toLowerCase();
  }

  openTrainingDetails(element: any): void {
    const dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
      width: '250px',
      data: {actualTraining: element}
    });
    console.log(element);
  }

  snackbarProposed(element:TrainingElement) {
    this.trainingProposal = new TrainingProposal();
    this.trainingProposal.trainingName = element.trainingName;
    this.http.post('http://localhost:8080/api/training/propose', this.trainingProposal).subscribe( (response) => {
      this.snackbar.openFromComponent(SnackbarProposalComponent, {
          duration: 3000,
        });
      }
    );
  }

}

@Component({
  selector: 'dialog-overview-example-dialog',
  templateUrl: 'dialog-overview-example-dialog.html',
})
export class DialogOverviewExampleDialog {

  constructor(
    public dialogRef: MatDialogRef<DialogOverviewExampleDialog>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}

  @Component({
    selector: 'snackbar-proposal',
    templateUrl: 'snackbar-proposal.html',
    styles: [`
    .snackbar-proposal {
      color: hotpink;
    }
  `],
  })
  export class SnackbarProposalComponent {}


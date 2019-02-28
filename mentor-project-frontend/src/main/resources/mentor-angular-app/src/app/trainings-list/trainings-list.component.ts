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
  id: string;
  name: string;
  cost: string;
}

const ELEMENT_DATA: TrainingElement[] = [
  {id: '1', name: 'Hydrogen', cost: '24'},
  {id: '2', name: 'KKt', cost: '500'},
];

export interface DialogData {
  animal: string;
  name: string;
}

@Component({
  selector: 'app-trainings-list',
  templateUrl: './trainings-list.component.html',
  styleUrls: ['./trainings-list.component.css']
})
export class TrainingsListComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name', 'cost', 'propose', 'showDetails'];
  trainingsArray: MatTableDataSource<TrainingElement>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private http: HttpClient, private dialog: MatDialog, private snackbar: MatSnackBar) { }

  ngOnInit() {
    this.http.get<TrainingElement[]>('http://localhost:8080/api/trainings').subscribe( (elem) => {
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
      data: {name: 'aaa', animal: 'vvv'}
    });
    console.log(element);
  }

  snackbarProposed() {
    this.snackbar.openFromComponent(SnackbarProposalComponent, {
      duration: 3000,
    });
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


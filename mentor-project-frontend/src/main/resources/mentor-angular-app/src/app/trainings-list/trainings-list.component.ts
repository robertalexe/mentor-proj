import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";

export interface TrainingElement {
  id: string;
  name: string;
  cost: string;
}

const ELEMENT_DATA: TrainingElement[] = [
  {id: '1', name: 'Hydrogen', cost: '24'},
  {id: '2', name: 'KKt', cost: '500'},
];

@Component({
  selector: 'app-trainings-list',
  templateUrl: './trainings-list.component.html',
  styleUrls: ['./trainings-list.component.css']
})
export class TrainingsListComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name', 'cost'];
  trainingsArray: MatTableDataSource<TrainingElement>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private http: HttpClient) { }

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

}

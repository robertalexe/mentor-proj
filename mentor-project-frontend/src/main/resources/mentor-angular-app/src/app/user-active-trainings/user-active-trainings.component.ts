import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatTableDataSource} from "@angular/material";
import {TrainingElement} from "../trainings-list/trainings-list.component";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-user-active-trainings',
  templateUrl: './user-active-trainings.component.html',
  styleUrls: ['./user-active-trainings.component.css']
})
export class UserActiveTrainingsComponent implements OnInit {

  displayedColumns: string[] = ['mentor-name', 'training-name', 'training-cost'];
  activeTrainingsArray: MatTableDataSource<TrainingElement>;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get<TrainingElement[]>('http://localhost:8080/api/user-active-trainings').subscribe( (elem) => {
      this.activeTrainingsArray = new MatTableDataSource(elem);
      this.activeTrainingsArray.paginator = this.paginator;
    })
  }

}

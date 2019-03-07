import {Component, OnInit, ViewChild} from '@angular/core';

import {HttpClient} from "@angular/common/http";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";

export interface AppUser {
  email: string,
  firstName: string,
  lastName: string,
  active: boolean,
  userType: string
}


@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {

  displayedColumns: string[] = ['user-email', 'user-first-name', 'user-last-name', 'user-active', 'user-type'];
  usersArray: MatTableDataSource<AppUser>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get<AppUser[]>('/ui/api/app-users').subscribe( (elem) => {
      this.usersArray = new MatTableDataSource(elem);
      this.usersArray.paginator = this.paginator;
      this.usersArray.sort = this.sort;
    });
  }

  applyFilter(filterValue: string) {
    this.usersArray.filter = filterValue.trim().toLowerCase();
  }

}

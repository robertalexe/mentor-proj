import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

export interface Technology {
  techology: string
}

@Component({
  selector: 'app-technologies-list',
  templateUrl: './technologies-list.component.html',
  styleUrls: ['./technologies-list.component.css']
})
export class TechnologiesListComponent implements OnInit {

  technologiesArray: Array<Technology>;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get<Technology[]>('http://localhost:8080/api/technologies').subscribe( (elem) => {
      this.technologiesArray = elem;
    });
  }

}

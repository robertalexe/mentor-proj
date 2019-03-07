import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

export interface Technology {
  technology: string
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
    this.http.get<Technology[]>('/ui/api/technologies/all').subscribe( (elem) => {
      this.technologiesArray = elem;
    });
  }

}

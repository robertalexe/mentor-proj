import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-mentor-proposals',
  templateUrl: './mentor-proposals.component.html',
  styleUrls: ['./mentor-proposals.component.css']
})
export class MentorProposalsComponent implements OnInit {

  trainingProposals: any[];

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get<any[]>('http://localhost:8080/api/training/mentor-proposed').subscribe( (resp) => {
      this.trainingProposals = resp;
      console.log(this.trainingProposals);
    });
  }

}

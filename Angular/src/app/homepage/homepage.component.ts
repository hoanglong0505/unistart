import { Component, OnInit } from '@angular/core';
import { UniversityService } from '../service/university.service';
import { University } from '../shared/university.model';
import {trigger, style, transition, animate, keyframes, query, stagger} from '@angular/animations';
@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  test: University[];
  s: University = new University;
  constructor(private universityService: UniversityService ) { }

  ngOnInit() {
    this.universityService.getList().then((res: University[]) => {
      this.test = res;

       console.log(this.test);
  }).catch(err => {
      alert(err);
      // this.loadingService.stop();
  });
   }
select(u: University){
this.s = u;
}
}

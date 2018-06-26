import { Component, OnInit } from '@angular/core';
import { UniversityService } from '../service/university.service';
import {trigger, style, transition, animate, keyframes, query, stagger} from '@angular/animations';
@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  test: any;
  constructor(private universityService: UniversityService ) { }

  ngOnInit() {
    this.universityService.getList().then((res: any) => {
      this.test = res;

      // console.log(this.users);
  }).catch(err => {
      alert(err);
      // this.loadingService.stop();
  });
   }

}

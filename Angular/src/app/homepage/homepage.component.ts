import { Component, OnInit } from '@angular/core';
import { UniversityService } from '../service/university.service';
import { SubLocationService } from '../service/subLocation.service';
import { University } from '../shared/university.model';
import { SubLocation } from '../shared/subLocation';

import {trigger, style, transition, animate, keyframes, query, stagger} from '@angular/animations';
@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  Universitys: University[];
  listSub: SubLocation[];
  listSubCk: SubLocation[];
  constructor(private universityService: UniversityService,
    private subLocationService: SubLocationService ) { }

    ngOnInit() {
      this.universityService.getList().then((res: University[]) => {
        this.Universitys = res;

         console.log(this.Universitys);
    }).catch(err => {
        alert(err);
        // this.loadingService.stop();
    });
    this.subLocationService.getList().then((res: SubLocation[]) => {
      this.listSub = res;

       console.log(this.listSub);
  }).catch(err => {
      alert(err);
      // this.loadingService.stop();
  });
   }

check( id : number) {

  console.log(this.listSub);
}
}

import { Component, OnInit } from '@angular/core';
import { University } from '../shared/university.model';
import { UniversityService } from '../service/university.service';

@Component({
  selector: 'app-university',
  templateUrl: './university.component.html',
  styleUrls: ['./university.component.css']
})
export class UniversityComponent implements OnInit {
  Universitys: University[];
  constructor(private universityService: UniversityService) { }

  ngOnInit() {
    this.universityService.getList().then((res: University[]) => {
      this.Universitys = res;

       console.log(this.Universitys);
  }).catch(err => {
      alert(err);
      // this.loadingService.stop();
  });
  }

}

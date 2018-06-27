import { Component, OnInit } from '@angular/core';
import { University } from '../shared/university.model';
import { Level } from '../shared/level.model';
import { UniversityService } from '../service/university.service';
import { LevelService } from '../service/level.service';

@Component({
  selector: 'app-university',
  templateUrl: './university.component.html',
  styleUrls: ['./university.component.css']
})
export class UniversityComponent implements OnInit {
  Universitys: University[];
  Levels: Level[];

  constructor(private universityService: UniversityService,
    private levelService: LevelService) { }

  ngOnInit() {
    this.universityService.getList().then((res: University[]) => {
      this.Universitys = res;

       console.log(this.Universitys);
  }).catch(err => {
      alert(err);
      // this.loadingService.stop();
  });

  this.levelService.getList().then((res: Level[]) => {
    this.Levels = res;

     
}).catch(err => {
    alert(err);
    // this.loadingService.stop();
});

  }

}

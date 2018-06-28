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
  //---LEVEL---
  Levels: Level[];
  FilterLv: Map<Number, Level>;
  filterLevel: Function;
  //------------

  constructor(private universityService: UniversityService,
    private levelService: LevelService) { }

  ngOnInit() {

    this.FilterLv = new Map(); //init map

    //---------- LOAD UNIVSERSITY LIST -------
    this.universityService.getList().then((res: University[]) => {
      this.Universitys = res;
      res.forEach(u => {
        u.show = true;//all visible
      });

      console.log(this.Universitys);
    }).catch(err => {
      alert(err);
      // this.loadingService.stop();
    });

    //---------- LOAD LEVEL LIST -------
    this.levelService.getList().then((res: Level[]) => {
      this.Levels = res;
      this.Levels.forEach(l => {
        l.status = false;//all subcriterias are disabled
        this.FilterLv.set(l.levelId, l);//put into map by id
      });

      //----- CREATE LEVEL 'ALL'---------
      var allLevel = new Level();
      allLevel.levelId = -1;
      allLevel.levelName = "Tất cả";
      allLevel.status = true;
      this.FilterLv.set(-1, allLevel);//select all is default

    }).catch(err => {
      alert(err);
      // this.loadingService.stop();
    });


    //----- FILTER LEVEL FUNCTION------
    this.filterLevel = function (allChoice) {
      var f = this.FilterLv;
      var allLv = f.get(-1);
      if (!allChoice) { //is not call by click 'Select all' check box
        var selected = false;
        
        //check if any box (except 'all') is selected
        this.Levels.forEach(lv => {
          if (lv.status)
            selected = true;
        }); 

        if (selected) {//if selected, then filter
          this.Universitys.forEach(u => {
            if (f.get(u.levelId).status) {
              u.show = true;
            } else {
              u.show = false;
            }
          });
          allLv.status = false;
        } else { // if not, turn back to 'Select all' box
          this.Universitys.forEach(u => {
            u.show = true;
          });
          this.Levels.forEach(lv => {
            lv.status = false;
          });
          allLv.status = true; //turn on 'select all' box
        }

      } else {//Called by 'Select all' box
        setTimeout(function () { allLv.status = true }, 1);//always checked if selected
        this.Universitys.forEach(u => {
          u.show = true;
        });
        this.Levels.forEach(lv => {
          lv.status = false;
        });
      }
    }
    //----------- END FILTER LEVEL FUNCTION------------
  }

}

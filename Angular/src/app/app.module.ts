import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule} from '@angular/forms';
import { HttpModule } from '@angular/http';



import { AppComponent } from './app.component';
import { ApiService } from './app.service';
import { UniversityService } from './service/university.service';
import { LevelService } from './service/level.service';
import { SubLocationService } from './service/subLocation.service';
import { HomeComponent } from './home/home.component';
import { HomepageComponent } from './homepage/homepage.component';
import { MyPipePipe } from './my-pipe.pipe';
import { MyDirectiveDirective } from './my-directive.directive';
import { UniversityComponent } from './university/university.component';


const routes: Routes = [
  { path: '', component: HomepageComponent },
  { path: 'home', component: HomepageComponent },
  { path: 'university', component: UniversityComponent }
];



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HomepageComponent,
    MyPipePipe,
    MyDirectiveDirective,
    UniversityComponent
  ],
  imports: [
    HttpModule,
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [ApiService, UniversityService
    , LevelService, SubLocationService],
  bootstrap: [AppComponent]
})
export class AppModule { }

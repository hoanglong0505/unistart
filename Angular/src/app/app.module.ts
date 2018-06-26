import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes } from '@angular/router';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule} from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { ApiService } from './app.service';
import { UniversityService } from './service/university.service';
import { HomeComponent } from './home/home.component';
import { HomepageComponent } from './homepage/homepage.component';
import { MyPipePipe } from './my-pipe.pipe';
import { MyDirectiveDirective } from './my-directive.directive';

const routes: Routes = [
  { path: '', component: HomepageComponent, pathMatch: 'full' }];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HomepageComponent,
    MyPipePipe,
    MyDirectiveDirective
  ],
  imports: [
    HttpModule,
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule
  ],
  providers: [ApiService, UniversityService],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ApiService } from './app.service';
import { HomeComponent } from './home/home.component';
import { Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'home', component: HomeComponent, pathMatch: 'full' }];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [ApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }

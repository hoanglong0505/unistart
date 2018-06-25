import { Component } from '@angular/core';
import { Router } from '@angular/router';
declare var $: any;
@Component({selector: 'home',
templateUrl: './home.component.html'})
export class HomeComponent {
    constructor(private router: Router) {}
}

import { Injectable } from '@angular/core';
import { ApiService } from '../app.service';
import { Http } from '@angular/http';

@Injectable()
export class UniversityService {
    constructor(private apiService: ApiService, private http: Http) { }
    // getList() {
    //     return new Promise((resolve, reject) => {
    //         console.log('abababa');
    //         this.apiService.get('test/test').then(res => {
    //             resolve(res.json());
    //         }).catch(err => {
    //             reject(err);
    //         });
    //     });
    // }
    getList() {
        return new Promise((resolve, reject) => {
            console.log('abababa');
            this.apiService.get('').then(res => {
                resolve(res.json());
                console.log(res);
            }).catch(err => {
                reject(err);
            });
        });
    }
}


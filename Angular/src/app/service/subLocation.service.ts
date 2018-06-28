import { Injectable } from '@angular/core';
import { ApiService } from '../app.service';
import { Http } from '@angular/http';

@Injectable()
export class SubLocationService {
    constructor(private apiService: ApiService, private http: Http) { }
    getList() {
        return new Promise((resolve, reject) => {

            this.apiService.get('SubLocation/get-all').then(res => {
                resolve(res.json());
            }).catch(err => {
                reject(err);
            });
        });
    }

}

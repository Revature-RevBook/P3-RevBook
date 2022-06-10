import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {map, catchError} from 'rxjs/operators'
import { Router } from '@angular/router';
import { UpdateUser } from 'src/app/entity/UpdateUser';


@Injectable({
  providedIn: 'root'
})
export class UpdateUserService {

  constructor(private httpClient: HttpClient) { }

  update(updateUser: UpdateUser): Observable<object> {
    //hardcoded id for testing purposes
    // return this.httpClient.put<UpdateUser>(`http://localhost:8080/user/update/2`, updateUser);

    //non hardcoded commented out for now
    return this.httpClient.put<UpdateUser>(`http://localhost:8080/user/update/${sessionStorage.getItem("user_id")}`, updateUser);

  }
}

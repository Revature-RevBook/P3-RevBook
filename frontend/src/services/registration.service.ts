import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/entity/user';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http:HttpClient) { }

  addUser(user:Partial<User>) {
    return this.http.post<any>('http://localhost:8080/register', user);
  }
}

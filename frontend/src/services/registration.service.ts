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

  isUnique(user: Partial<User>) {
    return this.http.get<any>('http://localhost:8080/users/unique'+`?username=${user.username}&email=${user.email}`);
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/entity/user';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http:HttpClient) { }

  addUser(user:Partial<User>) {
    return this.http.post<any>('http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/register', user);
  }
}

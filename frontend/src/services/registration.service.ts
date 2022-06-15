import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/entity/user';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http:HttpClient) { }

  addUser(user:Partial<User>) {
    return this.http.post<any>('http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/register', user);
  }

  isUnique(user: Partial<User>) {
    return this.http.get<any>('http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/users/unique'+`?username=${user.username}&email=${user.email}`);
  }
}

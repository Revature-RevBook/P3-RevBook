import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/Entities/User';
import axios from 'axios';
@Injectable({
  providedIn: 'root'
})
export class UserService {


  registerUser : User; 
  url : string = "http://localhost:8080/api/v1"


  constructor(private http : HttpClient) { 
    this.registerUser = {
      user_email : "",
      user_name : "",
      password : ""
    }

  }
  // http://localhost:8080/api/v1/user/unique?user-name=newUser1&user-email=newUser1@domain.com
  isUnique(user: User) {
    return this.http.get<any>(this.url+'/user/unique'+`?user-name=${user.user_name}&user-email=${user.user_email}`);
  }

  register(user: User) {
    console.log(user);
    return this.http.post<any>("http://localhost:8080/api/v1/user" , user);
  }


}

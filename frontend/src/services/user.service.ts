import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/entity/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  addUser(user:Partial<User>) {
    return this.http.post<User>('http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/users', user);
  }

  getAllUsers() {
    return this.http.get<User[]>('http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/users');
  }

  getUserById(userId:Number) {
    return this.http.get<User>(`http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/users/${userId}`);
  }

  updateUser(user:User) {
    return this.http.put<User>(`http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/users/${user.userId}`, user);
  }

  deleteUser(userId:Number) {
    return this.http.delete(`http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/users/${userId}`);
  }
}

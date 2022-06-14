import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/entity/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  addUser(user:Partial<User>) {
    return this.http.post<User>('http://localhost:8080/users', user);
  }

  getAllUsers() {
    return this.http.get<User[]>('http://localhost:8080/users');
  }

  getUserById(userId:Number) {
    return this.http.get<User>(`http://localhost:8080/users/${userId}`);
  }

  updateUser(user:User) {
    return this.http.put<User>(`http://localhost:8080/users/${user.userId}`, user);
  }

  deleteUser(userId:Number) {
    return this.http.delete(`http://localhost:8080/users/${userId}`);
  }
}

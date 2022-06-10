import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { User } from 'app/entity/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  model: any = {};
  // sessionId: any = "";
  // model2: any = {};
  user!:User;
  username!:string;
  password!:string;

  constructor(
    private router: Router,
    private http: HttpClient,
    private titleService: Title
  ) { }

  ngOnInit(): void {
    this.titleService.setTitle('Login');
    this.user = {
      username: "",
      password: ""
    }
  }

  
  

  loginHtml() {
    let url = 'user/login';
    let username = this.model.username;
    let password = this.model.password;
    const params = new HttpParams()
  .set("username",username)
  .set("password",password);
    this.http.get('http://localhost:8080/api/user/login',{params})
    .subscribe(res => {
        if (res) {
        let user = res;
        sessionStorage.setItem(
          'username',
          this.model.username
        );
        this.router.navigate(['']);
      } else {
        alert("Login failed.");
      }
   }, err => {
      if (err) {
        // for an invalid post request
        let errorElement:any = document.getElementById('errorMsg');
        errorElement.innerHTML = "Invalid Username and Password";
      }
    });
  }
}
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { User } from 'src/entity/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  time = new Date();
  model: any = {};
  sessionId: any = "";

  user: User = {
    userId: 0,
    username: '',
    password: '',
    createdAt: this.time,
    updatedAt: this.time,
    email: '',
    profileImgLink: ''
  };

  constructor(
    private router: Router,
    private http: HttpClient,
    private titleService: Title
  ) { }

  ngOnInit(): void {
    this.titleService.setTitle('Login');
  }

  login() {
    let url = 'http://revbook-env.eba-mj2xqwak.us-east-1.elasticbeanstalk.com/login';
    this.http.post<any>(url, {
      username: this.model.username,
      password: this.model.password
    }).subscribe(res => {
        if (res) {
        let session = res;
        this.sessionId = session.session_id;
        this.user = session.sessionUser;

        sessionStorage.setItem(
          'token',
          this.sessionId
        );

        sessionStorage.setItem('userId', String(this.user.userId));
        sessionStorage.setItem('username', this.user.username);
        sessionStorage.setItem('password', this.user.password);
        sessionStorage.setItem('createdAt', String(this.user.createdAt));
        sessionStorage.setItem('updatedAt', String(this.user.updatedAt));
        sessionStorage.setItem('email', this.user.email);
        sessionStorage.setItem('profileImgLink', this.user.profileImgLink);

        this.router.navigate(['']);
      } else {
        alert("Authentication failed.");
      }
   }, err => {
      if (err) {
        let errorElement:any = document.getElementById('errorMsg');
        errorElement.innerHTML = "Invalid Username and Password";
      }
    });
  }
}
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
    // url +="?username=" + username + "&password=" + password;
    // sends request through proxy for authentication
    const params = new HttpParams()
  .set("username",username)
  .set("password",password);
    // this.http.post<any>(url, {
    //   username: this.model.username,
    //   password: this.model.password
    // })
    this.http.get('http://localhost:8080/api/user/login',{params})
    .subscribe(res => {
      // gets authentication info from http response for angular usage
        if (res) {
        let user = res;
        // this.model2 = session.sessionUser;

        // refer to each login session by 'token'
        // sessionStorage.setItem(
        //   'token',
        //   this.sessionId
        // );

        // localStorage.setItem('userId', this.model2.userId);
        // localStorage.setItem('user-username', this.model2.username);
        // localStorage.setItem('user-password', this.model2.password);

         // For later implementation of roles
        // localStorage.setItem('user-role', this.model2.role.role_name);

       
        // if(this.model2.role.role_name == 'ADMIN') {
        //   let url = 'api/techstacks/user/' + this.model2.userId;
        //   this.http.get<any>(url, {}).subscribe(res => {
        //     localStorage.setItem('techStackArray', res);
        //     let techStackArray:any = res;
        //     for(let x = 0; x < techStackArray.length; x++) {
        //       console.log(techStackArray[x]);
        //     }
        //   })
        // }

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
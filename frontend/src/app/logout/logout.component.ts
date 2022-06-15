import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private http: HttpClient, private router: Router,
    private title:Title) { }

  ngOnInit(): void {
    this.title.setTitle('Sign Out');
    let sessionId:any = sessionStorage.getItem('token');
    if(sessionId != null) {
      this.logout();
    }
  }

  logout() {
    let header = new Headers();
    let sessionId:any = sessionStorage.getItem('token');

    if(sessionId == null) {
      let msg:any = document.getElementById("message");
      msg.innerHTML = "You are not signed in!";
    }

    header.set("Authorization", sessionId);
    
    this.http.get<any>("http://p3revbook-env.eba-9n8rwwpy.us-east-1.elasticbeanstalk.com/login").subscribe();

    localStorage.clear();
    sessionStorage.clear();

    window.setTimeout(function() {
      window.location.href = '';
    }, 3000);
  }

}

import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private http: HttpClient, private router: Router,
    private title:Title) {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
  }

  ngOnInit(): void {
    this.title.setTitle('Home');
    this.checkIfSignedIn();

    // Prevent default event when form is submitted (not important, but prevents console from warning about it):
    document.getElementById('siteButtons')?.addEventListener("click", function(event){
      event.preventDefault()
    });
  }

  login() {
    console.log('login');
    this.router.navigate(['/login']);
  }

  signup() {
    console.log('Sign up');
    this.router.navigate(['/register']);
  }

  checkIfSignedIn() {
    let sessionId = sessionStorage.getItem('token');
    if(sessionId != null) {
      let loginBtn = document.getElementById('logSignBtn');
      loginBtn!.style.display="none";
    }
  }
}

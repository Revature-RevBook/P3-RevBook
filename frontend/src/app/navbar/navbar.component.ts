import { HttpClient } from '@angular/common/http';
import { Component, CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  
  constructor(
    private router: Router,
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    this.checkIfSignedIn();

    // Prevent default event when form is submitted (not important, but prevents console from warning about it):
    document.getElementById('navButtons')?.addEventListener("click", function(event){
      event.preventDefault()
    });
  }

  logout() {
    this.router.navigate(['/logout']);
  }

  checkIfSignedIn() {
    let sessionId = sessionStorage.getItem('token');
    if(sessionId != null) {
      let logoutBtn = document.getElementById('logout');
      logoutBtn!.style.display="block";
    }
  }

}

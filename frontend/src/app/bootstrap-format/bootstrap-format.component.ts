import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bootstrap-format',
  templateUrl: './bootstrap-format.component.html',
  styleUrls: ['./bootstrap-format.component.css']
})
export class BootstrapFormatComponent implements OnInit {


  constructor(
    private router: Router,
    private http: HttpClient) 
    { }

  ngOnInit(): void {
  }

  login() {
    console.log("Clicked Login Button");
    this.router.navigate(['/login']);
  }

  signup() {
    console.log("Clicked Sign Up Button");
  }

}

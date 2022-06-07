import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bootstrap-format',
  templateUrl: './bootstrap-format.component.html',
  styleUrls: ['./bootstrap-format.component.css']
})
export class BootstrapFormatComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  login() {
    console.log("Clicked Login Button");
  }

  signup() {
    console.log("Clicked Sign Up Button");
  }

}

import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/entity/user';
import { RegistrationService } from 'src/services/registration.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user:Partial<User> = {
    username: "",
    password: "",
    email: ""
  }

  constructor(
    private router: Router,
    private http: HttpClient,
    private registrationService: RegistrationService
  ) { }

  ngOnInit(): void {
  }

  register() {
    this.registrationService.addUser(this.user).subscribe(res => {
      if (res == true) {
        alert('Account Created.');
        this.router.navigate(['']);
      }else {
        alert('Failed to Create Account.');
      }
    })
  }

}
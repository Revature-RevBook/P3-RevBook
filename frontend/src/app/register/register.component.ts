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

  haspasswordError: boolean = false;
  hasUserNameError: boolean = false;
  hasEmailError: boolean = false;
  isUserUnique: boolean = true;
  hasSuccessfullyRegistered: boolean = false;

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

  userInputValidation(user:Partial<User>) : boolean {
    if (user.username === "" || user.username!.length < 1) {
        this.hasUserNameError = true;
    } if (!user.email!.includes('@') || user.email === "" || !user.email!.includes('.')) {
        this.hasEmailError = true;
    } if (user.password === "" || user.password!.length < 1) {
        this.haspasswordError = true;
    }
    return !this.hasUserNameError && !this.hasEmailError && !this.haspasswordError;
  } 

  register() {
    this.hasSuccessfullyRegistered = false;
    this.haspasswordError = false;
    this.hasUserNameError = false;
    this.hasEmailError = false;
    if (this.userInputValidation(this.user)) {
      this.registrationService.isUnique(this.user).subscribe(response => {
        this.isUserUnique = response.isUnique;
        if (this.isUserUnique) {
          this.registrationService.addUser(this.user).subscribe(response => {
            console.log(response)
            this.hasSuccessfullyRegistered = true;
          })
        }
      });   
    }
  } 

}
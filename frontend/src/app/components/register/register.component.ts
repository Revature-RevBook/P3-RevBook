import { Component, OnInit, NgModule } from '@angular/core';
import { User } from 'app/Entities/User';
import { UserService } from 'app/services/user-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user!: User;
  haspasswordError! : boolean;
  hasUserNameError!: boolean;
  hasEmailError! : boolean;
  isUserUnique! : boolean;
  hasSuccessfullyRegistered! : boolean;

  

  constructor(private userService : UserService) {}

  ngOnInit(): void {
    this.haspasswordError = false;
    this.hasUserNameError = false;
    this.hasEmailError = false;
    this.isUserUnique = true;
    this.hasSuccessfullyRegistered = false;
    this.user = {
      userEmail : "",
      userName : "",
      password : ""
    }
  }


  userInputValidation(user : User) : boolean {
    if (this.user.userName === "" || this.user.userName.length < 1) {
        this.hasUserNameError = true;
    } if (!this.user.userEmail.includes('@') || this.user.userEmail === "" || !this.user.userEmail.includes('.')) {
        console.log(this.user.userEmail);
        this.hasEmailError = true;
    } if (this.user.password === "" || this.user.password.length < 1) {
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
      this.userService.isUnique(this.user).subscribe(response => {
        this.isUserUnique = response.isUnique;
        if (this.isUserUnique) {
          this.userService.register(this.user).subscribe(response => {
            console.log(response)
            this.hasSuccessfullyRegistered = true;
          })
        }
      });   
    }
  } 


}

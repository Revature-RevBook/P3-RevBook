import { Component, OnInit, NgModule } from '@angular/core';
import { User } from 'src/Entities/User';
import { UserService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user!: User
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
      user_email : "",
      user_name : "",
      password : ""
    }
  }


  userInputValidation(user : User) : boolean {
    if (this.user.user_name === "" || this.user.user_name.length < 1) {
        this.hasUserNameError = true;
    } if (!this.user.user_email.includes('@') || this.user.user_email === "" || !this.user.user_email.includes('.')) {
        console.log(this.user.user_email);
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

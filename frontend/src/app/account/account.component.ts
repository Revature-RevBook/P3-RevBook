import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { User } from 'src/entity/user';
import { UserService } from 'src/services/user.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  time = new Date();
  modelDeleteAccount: any = {};

  user:User = {
    userId: 0,
    username: '',
    password: '',
    createdAt: this.time,
    updatedAt: this.time,
    email: '',
    profileImgLink: ''
  }

  constructor(private titleService: Title, 
    private http: HttpClient, 
    private router: Router,
    private userService: UserService) { }

  ngOnInit(): void {
    this.titleService.setTitle('User Dashboard');
    this.initAccountDetails();
  }

  initAccountDetails() {
    this.user.userId = Number(sessionStorage.getItem('userId'));
    this.user.username = String(sessionStorage.getItem('username'));
    this.user.createdAt = new Date(Date.parse(String(sessionStorage.getItem('createdAt'))));
    this.user.email = String(sessionStorage.getItem('email'));
    this.user.profileImgLink = String(sessionStorage.getItem('profileImgLink'));
  }

  updateAccount() {
    if(this.user.username == '' || this.user.password == '' || this.user.email == '') {
      alert('Please fill out all fields with current or new information before updating.');
      return;
    }

    this.userService.updateUser(this.user).subscribe(res => {
      if (res) {
        alert("Account Updated. For security purposes, please sign in again.");
        this.router.navigate(['/logout']);
      }else {
        alert('No Response. Failed to update account.');
      }
    })

  }

  deleteAccount() {
    let deleteText = this.modelDeleteAccount.deleteText;
    if(deleteText == 'deleteMyAccount') {
      alert('Account will be deleted.');

      this.userService.deleteUser(this.user.userId).subscribe(res => {
        if (res) {
          console.log(res);
          this.router.navigate(['/logout']);
        }else {
          alert("No Response. Delete failed.");
        }
      })
    }
  }

}

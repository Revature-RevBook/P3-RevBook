import { Component, OnInit } from '@angular/core';
import { UpdateUserService } from 'src/service/update-user.service';
import { UpdateUser } from '../entity/UpdateUser';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  model: any = {};



  updateUser: UpdateUser = new UpdateUser();

  constructor(private updateUserService: UpdateUserService) { }

  ngOnInit(): void {
  }

  usernameUpdate(){
    this.updateUserService.update(this.updateUser).subscribe(data=>{
      console.log('this is data ' + data);
      if(data){
        console.log('User updated successfully!');
      } else {
        console.log('Something went wrong with update!')
      }
    })
    
  }

  passwordUpdate(){

  }

  emailUpdate(){

  }

  imageLinkUpdate(){

  }

}

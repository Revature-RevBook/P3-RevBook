import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BootstrapFormatComponent } from './bootstrap-format/bootstrap-format.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

const routes: Routes = [
  {path: '', component: BootstrapFormatComponent},
  {path: 'userprofile', component: UserProfileComponent}
];

@NgModule({
  
  
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

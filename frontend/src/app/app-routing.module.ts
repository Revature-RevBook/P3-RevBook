import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountComponent } from './account/account.component';
import { AuthenticationGuard } from './authentication.guard';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { MessagesComponent } from './messages/messages.component';
import { PostFeedComponent } from './post-feed/post-feed.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  {path: '', canActivate:[AuthenticationGuard], children: [
    {path: '', component: HomeComponent},
    {path: 'login', component: LoginComponent},
    {path: 'logout', component: LogoutComponent},
    {path: 'register', component: RegisterComponent},
    {path: 'account', component: AccountComponent},
    {path: 'feed', component: PostFeedComponent},
    {path: 'messages', component: MessagesComponent},


    {path: '**', redirectTo: ''}
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

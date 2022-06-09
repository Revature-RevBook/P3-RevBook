import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BootstrapFormatComponent } from './bootstrap-format/bootstrap-format.component';
import { PostFeedComponent } from './components/post-feed/post-feed.component';
import { RegisterComponent } from './components/register/register.component';
import { PostDetailsComponent } from './components/post-details/post-details.component';

const routes: Routes = [
  {path: '', component: BootstrapFormatComponent},
  {path: 'register', component : RegisterComponent},
  {path: 'post-feed', component : PostFeedComponent},
  {path: 'post-feed/:id', component: PostDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

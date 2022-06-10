import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { BootstrapFormatComponent } from './bootstrap-format/bootstrap-format.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { PostFeedComponent } from './post-feed/post-feed.component';

const routes: Routes = [
  {path: '', component: BootstrapFormatComponent},
  {path: 'create', component: CreatePostComponent},
  {path: 'post', component: PostFeedComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

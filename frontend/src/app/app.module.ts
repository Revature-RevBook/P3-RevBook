import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BootstrapFormatComponent } from './bootstrap-format/bootstrap-format.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { PostFeedComponent } from './post-feed/post-feed.component';

@NgModule({
  declarations: [
    AppComponent,
    BootstrapFormatComponent,
    CreatePostComponent,
    PostFeedComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

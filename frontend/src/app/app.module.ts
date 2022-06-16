import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RequestInterceptor } from './request.interceptor';
import { LogoutComponent } from './logout/logout.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AccountComponent } from './account/account.component';
import { PostFeedComponent } from './post-feed/post-feed.component';
import { PostFeedTableComponent } from './post-feed-table/post-feed-table.component';
import { VotePostComponent } from './vote-post/vote-post.component';
import { CommonModule } from '@angular/common';
import { CommentTableComponent } from './comment-table/comment-table.component';
import { CommentComponent } from './comment/comment.component';
import { VoteCommentComponent } from './vote-comment/vote-comment.component';
import { MessagesComponent } from './messages/messages.component';
import { MessagesTableComponent } from './messages-table/messages-table.component';
import { SubCommentComponent } from './sub-comment/sub-comment.component';
import { SubCommentTableComponent } from './sub-comment-table/sub-comment-table.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    LogoutComponent,
    LoginComponent,
    RegisterComponent,
    AccountComponent,
    PostFeedComponent,
    PostFeedTableComponent,
    VotePostComponent,
    CommentTableComponent,
    CommentComponent,
    VoteCommentComponent,
    MessagesComponent,
    MessagesTableComponent,
    SubCommentComponent,
    SubCommentTableComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    CommonModule,
    FormsModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: RequestInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
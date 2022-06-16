import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class RequestInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // Get token from sessionStorage if user has logged in:
    let token = sessionStorage.getItem('token');

    // If user has a token, append the token to each request:
    if (token) {
      request = request.clone({ headers: request.headers.set('Authorization', token)});
    }

    // By default, handle HTTP request normally:
    return next.handle(request);
  }
}

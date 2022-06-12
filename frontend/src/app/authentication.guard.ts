import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationGuard implements CanActivate {

  constructor(private router: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      let token = null;

      // General routes that all users have access to:
      if (state.url == '/login' || state.url == '/register' || state.url == '/') {
        return true;
      }

      // Get token from session storage for routes that require token:
      token = sessionStorage.getItem('token');

      // Routes that require a token, but user does not have one:
      if (state.url == '/logout' || state.url == '/feed' || state.url == '/messages') {
        if(!token) {
          return this.router.parseUrl('');
        }
      }

      if (state.url == '/account' && !token) {
        return this.router.parseUrl('/login');
      }

      // Routes that require a token, and the user has one, but does not have permission:


      // Any route not accounted for AND user does not have a token:
      if (!token) {
        return this.router.parseUrl('/login');
      }

      // Any route not accounted for AND user has token:
      return true;
  }
  
}

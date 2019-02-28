import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

import { AuthenticationService } from '../_services/authentication.service';

@Injectable({ providedIn: 'root' })
export class RoleGuard implements CanActivate {
  constructor(private router: Router, private authenticationService: AuthenticationService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const currentRole = this.authenticationService.getUserRole();
    if (currentRole === 'USER' && route.routeConfig.path === 'user-homepage') {
        return true;
    }
    if (currentRole === 'MENTOR' && route.routeConfig.path === 'mentor-homepage') {
      return true;
    }
    if (currentRole === 'ADMIN' && route.routeConfig.path === 'admin-homepage') {
      return true;
    }

    // not proper role so redirect to forbidden page
    this.router.navigate(['/forbidden']);
    return false;
  }
}

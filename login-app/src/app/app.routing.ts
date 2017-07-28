import {RouterModule, Routes} from '@angular/router';
import {ModuleWithProviders} from '@angular/core';
import {HomeComponent} from "./home.component";
import {LoginComponent} from "./login/login.component";
import {UserComponent} from "./user-signup/user.component";

const appRoutes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: UserComponent}
];

export const appRoutingModule: ModuleWithProviders = RouterModule.forRoot(appRoutes, {useHash: true});

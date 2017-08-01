import {RouterModule, Routes} from '@angular/router';
import {ModuleWithProviders} from '@angular/core';
import {HomeComponent} from "./home.component";
import {LoginComponent} from "./login/login.component";
import {UserComponent} from "./user-signup/user.component";
import {DisplayUserComponent} from "./user-signup/display-user.component";
import {EditUserComponent} from "./user-signup/edit-user.component";

const appRoutes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: UserComponent},
  { path: 'users', component: DisplayUserComponent},
  {  path:'users/edit/:id', component:EditUserComponent}
];

export const appRoutingModule: ModuleWithProviders = RouterModule.forRoot(appRoutes, {useHash: true});

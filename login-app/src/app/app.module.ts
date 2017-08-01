import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home.component';
import { FooComponent } from './foo.component';
import {MdButtonModule, MdCardModule, MdIconModule, MdMenuModule, MdToolbarModule} from "@angular/material";
import {BrowserAnimationsModule, NoopAnimationsModule} from "@angular/platform-browser/animations";
import {appRoutingModule} from "./app.routing";
import {UserComponent} from "./user-signup/user.component";
import {RouterModule} from "@angular/router";
import {UserService} from "./user-signup/user.service";
import {DisplayUserComponent} from "./user-signup/display-user.component";
import {EditUserComponent} from "./user-signup/edit-user.component";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    FooComponent,
    UserComponent,
    DisplayUserComponent,
    EditUserComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpModule,
    MdToolbarModule,
    MdMenuModule,
    MdCardModule,
    MdIconModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    MdButtonModule,
    appRoutingModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }

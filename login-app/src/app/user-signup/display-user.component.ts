

import {Component, OnInit} from "@angular/core";
import {User} from "./user.model";
import {UserService} from "./user.service";
import {Router} from "@angular/router";

@Component({
  selector : 'app-display-user',
  templateUrl: "./display-user.component.html"
})

export class DisplayUserComponent implements OnInit{

  users : User[];

  constructor(private userService : UserService,
              private router : Router){

  }

  ngOnInit(){
    this.getUser();
  }

  getUser(){
    this.userService.query().subscribe((res) => this.onSuccess(res), () => {console.log('error')});
  }

  onSuccess(res){
    this.users = res;
    console.dir(res);
  }

  toggle(id){
    this.userService.toggle(id).subscribe((res) => this.onToggleSuccess(), () => console.log('error'));
  }

  onToggleSuccess(){
    this.getUser();
  }

  edit(id){
    this.router.navigate(['/user/edit/'+id]);
  }

  delete(id){
    this.userService.delete(id).subscribe((res) => this.getUser(), () => console.log('error'));
  }

}

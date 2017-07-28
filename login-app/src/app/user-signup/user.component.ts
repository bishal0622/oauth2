import {Component} from "@angular/core";
import {User} from "./user.model";

@Component({
  selector: 'app-signup',
  templateUrl: './user.component.html'
})

export class UserComponent{
  user: User;

  constructor(){
    this.user = new User();
  }

  signup(){
    console.log("userName: ",this.user.username);
    console.log("password: ",this.user.password);
  }
}

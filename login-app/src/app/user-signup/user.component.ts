import {Component} from "@angular/core";
import {User} from "./user.model";
import {UserService} from "./user.service";
import {RequestOptions} from "@angular/http";

@Component({
  selector: 'app-signup',
  templateUrl: './user.component.html'
})

export class UserComponent{
  user: User;

  constructor(private userService: UserService){
    this.user = new User();
  }

  signup(){
      this.userService.create(this.user).subscribe((res)=>this.onSuccess(res),() => console.log('error'));
  }

  onSuccess(res){
    console.log("SignUp success");
  }



}

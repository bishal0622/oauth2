import {Injectable} from "@angular/core";
import {CanActivate} from "@angular/router";
import {Cookie} from "ng2-cookies";

@Injectable()
export class isAdmin implements CanActivate {

  canActivate() {
    console.log("OnlyLoggedInUsers");

    if(Cookie.get('authority') == 'ROLE_admin'){
      return true;
    }else {
      window.alert("You don't have permission to view this page");
      return false;
    }
  }

}

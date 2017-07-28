import { Component } from '@angular/core';
import {AppService} from '../app.service'

@Component({
  selector: 'login-form',
  providers: [AppService],
  templateUrl: './login.component.html'

})
export class LoginComponent {
    public loginData = {username: "", password: ""};

    constructor(private _service:AppService) {}

    login() {
        this._service.obtainAccessToken(this.loginData);
    }


}

import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import { Cookie } from 'ng2-cookies';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

export class Foo {
  constructor(
    public id: number,
    public name: string) { }
}

@Injectable()
export class AppService {
  constructor(
    private _router: Router, private _http: Http){}

  obtainAccessToken(loginData){
    let params = new URLSearchParams();
    params.append('grant_type','password');
    params.append('username',loginData.username);
    params.append('password',loginData.password);

    let headers = new Headers({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8','Authorization': 'Basic '+btoa("my-trusted-client:secret")});
    let options = new RequestOptions({ headers: headers });
     this._http.post('http://localhost:9000/oauth/token',params.toString(), options)
    .map(res => res.json())
    .subscribe(
      data => this.saveToken(data),
      err => alert('Invalid Credentials')
    );
  }


  saveToken(token){
    var expireDate = new Date().getTime() + (1000 * token.expires_in);
    Cookie.set("access_token", token.access_token, expireDate);
    console.log('Obtained Access token');
    this._router.navigate(['/']);
  }

  getResource(resourceUrl) : Observable<Foo>{
    var headers = new Headers({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8', 'Authorization': 'Bearer '+Cookie.get('access_token')});
    var options = new RequestOptions({ headers: headers });
    return this._http.get(resourceUrl, options)
                   .map((res:Response) => res.json())
                   .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  checkCredentials(){
    if (!Cookie.check('access_token')){
        this._router.navigate(['/login']);
        return false;
    }else{
      return true;
    }
  }

  logout() {
    Cookie.deleteAll();
    this._router.navigate(['/login']);
  }


  saveCredential() {
    return this._http.get("http://localhost:9000/status" + "/?access_token=" + Cookie.get('access_token')).map((res) => res.json());
  }
}

import {Injectable} from "@angular/core";
import {Http, Headers,RequestOptions} from "@angular/http";
import {User} from "./user.model";
import 'rxjs/add/operator/map';
import { Cookie } from 'ng2-cookies';
import {Observable} from "rxjs/Observable";
import 'rxjs/add/operator/catch';


@Injectable()
export class UserService{

  private resourceUrl = 'http://localhost:9000/user';

  constructor(private http: Http) {

  }

  create(user: User) {
    let headers = new Headers({'Content-Type': 'application/x-www-form-urlencoded'});
    return this.http.post(this.resourceUrl,user,headers).map((res) => res.json());
  }

  query() {

    return this.http.get(this.resourceUrl+"/?access_token="+Cookie.get('access_token')).map((res) =>res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  find(id: number) {
    return this.http.get(`${this.resourceUrl}/${id}`+"/?access_token="+Cookie.get('access_token')).map((res) => res.json());
  }

  update(user: User,id : number) {
    return this.http.put(this.resourceUrl+'/'+id+"/?access_token="+Cookie.get('access_token'), user);
  }

  delete(id: number) {
    return this.http.delete(`${this.resourceUrl}/${id}`+"/?access_token="+Cookie.get('access_token'));
  }

  toggle(id: number) {
    return this.http.put('http://localhost:9000/user/activate/'+id+"/?access_token="+Cookie.get('access_token'),id).map((res) => res.json());
  }

}

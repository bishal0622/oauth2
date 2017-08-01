import {Injectable} from "@angular/core";
import {Http, Headers,RequestOptions} from "@angular/http";
import {User} from "./user.model";
import 'rxjs/add/operator/map';

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
    return this.http.get(this.resourceUrl);
  }

  find(id: number) {
    return this.http.get(`${this.resourceUrl}/${id}`).map((res) => res.json());
  }

  update(user: User,id : number) {
    return this.http.put(this.resourceUrl+'/'+id, user);
  }

  delete(id: number) {
    return this.http.delete(`${this.resourceUrl}/${id}`);
  }

  toggle(id: number) {
    return this.http.put('http://localhost:9000/user/activate/'+id,id).map((res) => res.json());
  }

}
